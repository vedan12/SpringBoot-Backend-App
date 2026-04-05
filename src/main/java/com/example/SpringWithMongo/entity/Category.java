package com.example.SpringWithMongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "categories")
public class Category {

    @Id
    private String id;

    private String categoryName;

    @DocumentReference(lazy = true)
    private List<Product> products = new ArrayList<>();

    // ✅ MANUAL GETTER
    public List<Product> getProducts() {
        return products;
    }
}
