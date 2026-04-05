package com.example.SpringWithMongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "suppliers")
@Data
public class Supplier {
    @Id
    private String id;
    private String name;
    private String region;
}