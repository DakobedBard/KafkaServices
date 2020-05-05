import { Component, OnInit, Input } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { CartProduct } from '../../models/cart-product';
import { Attribute } from '../../models/attribute';

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

    var colors: Attribute[] = [];
    var red: Attribute = {AttributeName: "Color",AttributeId: 1,AttributeValueId: 2, AttributeValue: "Red", productID: "a"}
    var blue: Attribute = {AttributeName: "Color",AttributeId: 1,AttributeValueId: 3, AttributeValue: "Blue", productID: "a"}
    colors.push(red);
    colors.push(blue);
    let product: CartProduct =  {productID: "a", imageurl:"https://dalinar-shoes.s3-us-west-2.amazonaws.com/air-jordan1-low.webp",
    name: "airflow", "brand":'Nike', price:140, Color: colors, Size: colors, description:'dope shoes', quantity:2, SizeId:2,ColorId:4};
    let cart: CartProduct[] = JSON.parse(localStorage.getItem('Cart')); 
        if(cart == null){
        cart = [];
        cart.push(product);
      } else{
        console.log("productID " + product.productID)
        // let currentProduct = cart.filter(a => a.productID == product.productID);
        // if(currentProduct.length > 0){
        //   cart.filter(a => {
        //     a.quantity = a.quantity + this.quantity;
        //   });
        // } else{
        //   cart.push(product);
        // }
      }
      localStorage.setItem('Cart', JSON.stringify(cart));
  }
}
    // let cart: CartProduct[] = JSON.parse(localStorage.getItem('Cart'));
    //   if(cart == null){
    //     cart = [];
    //     cart.push(product);
    //   } else{
    //     console.log("productID " + product.productID)
    //     // let currentProduct = cart.filter(a => a.productID == product.productID);
    //     // if(currentProduct.length > 0){
    //     //   cart.filter(a => {
    //     //     a.quantity = a.quantity + this.quantity;
    //     //   });
    //     // } else{
    //     //   cart.push(product);
    //     // }
    //   }

    //   localStorage.setItem('Cart', JSON.stringify(cart));

    //   console.log("The shopping cart product " + cart.length )

//   };
// }
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

    
  


