import { Component, OnInit, Input } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { CartProduct } from '../../models/cart-product';

import { AppHeaderComponent } from '../app-header/app-header.component';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-add-to-cart',
  templateUrl: './add-to-cart.component.html',
  styleUrls: ['./add-to-cart.component.scss']
})
export class AddToCartComponent implements OnInit {

  quantity: number;
  @Input() sizeId: number;
  @Input() colorId: number;
  @Input() productId: string;
  messge: string;
  constructor(private productService:ProductService,
              private dataService: CartService) { }

  ngOnInit() {
    this.quantity = 1;
    this.dataService.currentMessage.subscribe(msg => this.messge = msg);
  }

  onAddProductToCart(){
    let product: CartProduct;
  };
}
    // this.productService.getProductDetailsById(this.productId)
    // .subscribe(p => {
    //   product = p as CartProduct;
    //   product.quantity = this.quantity;
    //   product.SizeId = this.sizeId;
    //   product.ColorId = this.colorId;
    //   let cart: CartProduct[] = JSON.parse(localStorage.getItem('Cart'));
    //   if(cart == null){
    //     cart = [];
    //     cart.push(product);
    //   } else{
    //     let currentProduct = cart.filter(a => a.productID == product.productID);
    //     if(currentProduct.length > 0){
    //       cart.filter(a => {
    //         a.quantity = a.quantity + this.quantity;
    //       });
    //     } else{
    //       cart.push(product);
    //     }
    //   }
    //   this.dataService.updateCartItemCount(cart.length);
    //   this.dataService.updateShoppingCart(cart);
    //   localStorage.setItem('Cart', JSON.stringify(cart));
      // this.toastr.success('<i class="fas fa-check ml-1 pr-2"></i><strong>Product Added to the Cart</strong>', null, {
      //   timeOut: 3000,
      //   toastClass: 'toast-header',
      //   progressBar: true,
      //   progressAnimation: 'decreasing',
      //   closeButton: true,
      //   enableHtml: true
      // });

    
  


