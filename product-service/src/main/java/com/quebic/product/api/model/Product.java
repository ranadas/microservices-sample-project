package com.quebic.product.api.model;

import com.quebic.common.model.EntityBase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Product")
public class Product extends EntityBase {
    private String sellerId;
    private String name;
    private double price;
}
