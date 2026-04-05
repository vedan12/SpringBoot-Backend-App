package com.example.SpringWithMongo.repository;

import com.example.SpringWithMongo.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
    // Method to find a category by its name
    Category findByCategoryName(String categoryName);
}