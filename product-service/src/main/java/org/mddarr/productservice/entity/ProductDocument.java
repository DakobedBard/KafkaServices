package org.mddarr.productservice.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.ElementCollection;
import java.util.List;

@Document(collection = "products")
public class ProductDocument {
    @Id
    private String id;
    private String name;
    private String brand;
    private String imageurl;
    private List<String> colors;
    private List<String> sizes;
    private String description;
    private Integer price;
    public String getId() {
        return id;
    }

    public ProductDocument(String id, String name, String brand, String imageurl, List<String> colors, List<String> sizes, String description, Integer price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.imageurl = imageurl;
        this.colors = colors;
        this.sizes = sizes;
        this.description = description;
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ProductDocument(){

    }


}
