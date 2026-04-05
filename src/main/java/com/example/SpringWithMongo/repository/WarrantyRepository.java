package com.example.SpringWithMongo.repository;

import com.example.SpringWithMongo.entity.Warranty;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WarrantyRepository extends MongoRepository<Warranty, String> {
    // DSL: Find a warranty by certificate number
    Warranty findByCertificateNumber(String certificateNumber);
}