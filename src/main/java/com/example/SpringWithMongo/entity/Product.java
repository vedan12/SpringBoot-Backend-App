package com.example.SpringWithMongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "products")
@Data
public class Product {
    @Id
    private String id;
    private String sku;
    private double price;

    @DocumentReference // 1:1 Reference
    private Warranty warranty;

    @DocumentReference // N:M Reference
    private List<Supplier> suppliers = new ArrayList<>();
}