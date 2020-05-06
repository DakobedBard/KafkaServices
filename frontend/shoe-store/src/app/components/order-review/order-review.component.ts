import { Component, OnInit } from '@angular/core';
import { CartProduct } from '../../models/cart-product';

@Component({
  selector: 'app-review',
  templateUrl: './order-review.component.html',
  styleUrls: ['./order-review.component.scss']
})
export class OrderReviewComponent implements OnInit {

  checkoutProducts: CartProduct[];
  totalPrice: number = 0;
  constructor() {
    const products = JSON.parse(localStorage.getItem('Cart'));
    this.checkoutProducts = products;
    products.forEach((product) => {
			this.totalPrice += product.Price;
		});
  }

  ngOnInit() {
  }

}
