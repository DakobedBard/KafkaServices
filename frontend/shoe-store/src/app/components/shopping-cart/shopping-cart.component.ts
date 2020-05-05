import { Component, OnInit } from '@angular/core';
import { CartService } from '../../services/cart.service';
import { CartProduct } from '../../models/cart-product';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss']
})
export class ShoppingCartComponent implements OnInit {

  cart: CartProduct[] = [];
  total: number = 0;
  constructor(private cartService: CartService) { }

  ngOnInit() {
    this.cartService.cart.subscribe(a => this.cart = a);
    this.getTotal();
  }

  getCartProductItems(){
    this.cart = JSON.parse(localStorage.getItem('Cart'));
  }

  onRemoveProductsFromCart(productId: string){
    this.cart = this.cart.filter(a => a.productID != productId);
    localStorage.setItem('Cart', JSON.stringify(this.cart));
    this.cartService.updateCartItemCount(this.cart.length);
    this.cartService.updateShoppingCart(this.cart);
    this.getTotal();
  }

  onUpdateQuantity(type, productId){
    if(type == 1){
      this.cart.forEach((element, index) => {
        if(element.productID == productId){
          this.cart[index].quantity = element.quantity + 1;
        }
      });
    } else {
      this.cart.forEach((element, index) => {
        if(element.productID == productId){
          this.cart[index].quantity = element.quantity - 1;
        }
      });
    }
    this.getTotal();
  }

  getTotal(){
    this.total = 0;
    this.cart.forEach((element) => {
      this.total = this.total + (element.price*element.quantity);
    })
  }

}
