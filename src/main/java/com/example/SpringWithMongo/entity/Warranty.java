package com.example.SpringWithMongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "warranties")
@Data
public class Warranty {
    @Id
    private String id;
    private String certificateNumber;
    private int durationInMonths;
}