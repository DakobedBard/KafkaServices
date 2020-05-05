import { Attribute } from './attribute';

export class CartProduct {
    productID: string;
    name: string;
    brand: string;
    price: number;
    imageurl: string;
    Color: Attribute[];
    Size: Attribute[];
    description: string;
    quantity: number;
    SizeId: number;
    ColorId: number;
}
