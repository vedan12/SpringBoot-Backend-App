package com.example.SpringWithMongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String sku;
    private double price;

    @DocumentReference
    private Warranty warranty;

    @DocumentReference
    private List<Supplier> suppliers = new ArrayList<>();

    // ✅ MANUAL GETTERS
    public Warranty getWarranty() {
        return warranty;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }
}
