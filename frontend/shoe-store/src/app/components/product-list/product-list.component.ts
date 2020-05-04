import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../services/product.service'
import { Product } from '../../models/product'

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