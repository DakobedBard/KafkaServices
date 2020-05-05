package org.mddarr.authentication.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private String brand;
    private Double price;
    private Long quantity;
    private String imageurl;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public ProductEntity(){

    }

    public ProductEntity(String id, String name, String brand, Double price, Long quantity, String imageurl) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.imageurl = imageurl;
    }

    public String getImageurl() {  return imageurl; }
    public void setImageurl(String imageurl) { this.imageurl = imageurl;}
    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getBrand() {return brand;}
    public void setBrand(String brand) {this.brand = brand;}
    public String getName() { return name;}
    public void setName(String name) {this.name = name; }

}
