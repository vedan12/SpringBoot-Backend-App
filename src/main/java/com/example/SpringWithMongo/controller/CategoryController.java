package com.example.SpringWithMongo.controller;

import com.example.SpringWithMongo.entity.Category;
import com.example.SpringWithMongo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(catalogService.saveCategory(category));
    }

    // THE HARD RELATIONSHIP API: Linking 1:N
    @PostMapping("/{categoryId}/add-product/{productId}")
    public ResponseEntity<String> linkProductToCategory(
            @PathVariable String categoryId,
            @PathVariable String productId) {
        catalogService.linkProductToCategory(categoryId, productId);
        return ResponseEntity.ok("Relationship established successfully");
    }
}