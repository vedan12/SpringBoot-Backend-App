package com.example.SpringWithMongo.repository;

import com.example.SpringWithMongo.entity.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SupplierRepository extends MongoRepository<Supplier, String> {
    // DSL: Find all suppliers in a specific region
    List<Supplier> findByRegion(String region);
}