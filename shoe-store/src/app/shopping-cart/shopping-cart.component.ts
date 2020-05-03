import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/Shared/data.service';
import { CartProduct } from '../models/cart-product';
@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {
  cart: CartProduct[] = [];
  total: number = 0;
  constructor(
    private dataService: DataService
  ) { }

  ngOnInit() {
  }

  getCartProductItems(){
    this.cart = JSON.parse(localStorage.getItem('Cart'));
  }

  onRemoveProductsFromCart(productId: string){
    this.cart = this.cart.filter(a => a.ProductId != productId);
    localStorage.setItem('Cart', JSON.stringify(this.cart));
    this.dataService.updateCartItemCount(this.cart.length);
    this.dataService.updateShoppingCart(this.cart);
    this.getTotal();
  }

  onUpdateQuantity(type, productId){
    if(type == 1){
      this.cart.forEach((element, index) => {
        if(element.ProductId == productId){
          this.cart[index].Quantity = element.Quantity + 1;
        }
      });
    } else {
      this.cart.forEach((element, index) => {
        if(element.ProductId == productId){
          this.cart[index].Quantity = element.Quantity - 1;
        }
      });
    }
    this.getTotal();
  }

  getTotal(){
    this.total = 0;
    this.cart.forEach((element) => {
      this.total = this.total + (element.Price*element.Quantity);
    })
  }

}
