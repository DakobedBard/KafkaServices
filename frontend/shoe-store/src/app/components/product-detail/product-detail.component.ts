import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../../models/product'
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../../services/product.service'
import { Location } from '@angular/common';
import { Attribute } from '../../models/attribute';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  @Input() product: Product;
  
  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getProduct();
  }

  getProduct(): void {
    Attribute 
    var attributes: Attribute[];
    this.product =   {productID: "a", imageurl:"https://dalinar-shoes.s3-us-west-2.amazonaws.com/air-jordan1-low.webp" ,
     name: "airflow", "brand":'Nike', price:140, Color: attributes, Size: attributes, description:'dope shoes'}
    // let id: string= this.route.snapshot.paramMap.get('id');
    // this.productService.getProduct(id)
    //   .subscribe(product => this.product = product);
  }

  goBack(): void {
    this.location.back();
  }


}
