package com.example.SpringWithMongo.repository;


import com.example.SpringWithMongo.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByPriceBetween(double min, double max); // Query DSL
}