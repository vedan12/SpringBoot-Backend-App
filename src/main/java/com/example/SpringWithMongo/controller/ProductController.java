package com.example.SpringWithMongo.controller;

import com.example.SpringWithMongo.entity.Product;
import com.example.SpringWithMongo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private CatalogService catalogService;

    // CREATE: Save Product with an embedded/referenced Warranty
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product saved = catalogService.saveProduct(product);
        return new ResponseEntity<>(saved, HttpStatus.CREATED); // 201 Created
    }

    // READ ALL: Get all products in the catalog
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(catalogService.getAllProducts());
    }

    // READ BY ID: Get a specific product
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id) {
        return ResponseEntity.ok(catalogService.getProductById(id));
    }

    // SEARCH: Find products within a price range using Query DSL
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchByPrice(@RequestParam double min, @RequestParam double max) {
        return ResponseEntity.ok(catalogService.searchByPriceRange(min, max));
    }

    // DELETE: Remove product and handle orphan logic
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        catalogService.deleteProduct(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}