import { Component, OnInit } from '@angular/core';
import {ProductService} from '../product.service'
import { Product } from '../product'

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products = [];
  constructor(private productService :ProductService) { }

  ngOnInit() {
    this.getProducts();

  }



  getProducts():void{
    this.productService.getProducts().subscribe((data => {
      for (const d of (data as any)) {
        console.log("whhaatt " + d.name);
        this.products.push({
          id: d.id,
          imageurl: d.imageurl,
          name: d.name,
          brand: d.brand,
          price: d.price
        });
      }
  }))
  }

}
