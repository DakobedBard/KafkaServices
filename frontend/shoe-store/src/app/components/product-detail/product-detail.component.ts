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
  id: string;
  sizeId: number = 1;
  colorId: number = 1;
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
    var colors: Attribute[] = [];
    var red: Attribute = {AttributeName: "Color",AttributeId: 1,AttributeValueId: 2, AttributeValue: "Red", productID: "a"}
    var blue: Attribute = {AttributeName: "Color",AttributeId: 1,AttributeValueId: 3, AttributeValue: "Blue", productID: "a"}
    colors.push(red);
    colors.push(blue);
    this.product =   {productID: "a", imageurl:"https://dalinar-shoes.s3-us-west-2.amazonaws.com/air-jordan1-low.webp" ,
    name: "airflow", "brand":'Nike', price:140,  colors:["Red", "Blue"], sizes: ["6.5","7"], description:'dope shoes'}
    let id: string= this.route.snapshot.paramMap.get('id');
    this.id = id;
    this.productService.getProduct(id)
      .subscribe(product => {
        // console.log("product " + JSON.stringify(product.sizes))
        // var colors: Attribute[] = [];
        // var sizes: Attribute[] = [];
        // var red: Attribute = {AttributeName: "Color",AttributeId: 1,AttributeValueId: 2, AttributeValue: "Red", productID: "a"}
        // var blue: Attribute = {AttributeName: "Color",AttributeId: 1,AttributeValueId: 3, AttributeValue: "Blue", productID: "a"}
        // colors.push(red);
        // colors.push(blue);
        // product.Color = colors
        // product.Size = colors
        this.product = product;
      });
  }

  goBack(): void {
    this.location.back();
  }


}
