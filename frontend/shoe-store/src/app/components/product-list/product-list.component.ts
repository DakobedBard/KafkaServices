import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../services/product.service'
import { Product } from '../../models/product'

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  products = [
    {id: 1, imageurl:"https://dalinar-shoes.s3-us-west-2.amazonaws.com/air-jordan1-low.webp" , name: "airflow", "brand":'Nike', price:140},
    {id: 2, imageurl: "https://dalinar-shoes.s3-us-west-2.amazonaws.com/air-jordan1-low.webp" , name: "airflow", "brand":'Nike', price:140},
    {id: 3, imageurl: "https://dalinar-shoes.s3-us-west-2.amazonaws.com/air-jordan1-low.webp", name: "airflow", "brand":'Nike', price:140},
    {id: 4, imageurl: "https://dalinar-shoes.s3-us-west-2.amazonaws.com/air-jordan1-low.webp", name: "airflow", "brand":'Nike', price:140},
    {id: 5, imageurl: "https://dalinar-shoes.s3-us-west-2.amazonaws.com/air-jordan1-low.webp", name: "airflow", "brand":'Nike', price:140},
  ];
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
