package org.mddarr.productservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Attribute {
    String name;
    Integer attributeID;
    Integer valueID;
    String value;
    String productID;
}
