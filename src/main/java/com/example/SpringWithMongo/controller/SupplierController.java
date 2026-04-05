package com.example.SpringWithMongo.controller;

import com.example.SpringWithMongo.entity.Supplier;
import com.example.SpringWithMongo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(catalogService.saveSupplier(supplier));
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAll() {
        return ResponseEntity.ok(catalogService.getAllSuppliers());
    }

    // THE N:M RELATIONSHIP API: Link a Supplier to a Product
    @PostMapping("/{supplierId}/link-to-product/{productId}")
    public ResponseEntity<String> linkToProduct(
            @PathVariable String supplierId,
            @PathVariable String productId) {
        catalogService.addSupplierToProduct(supplierId, productId);
        return ResponseEntity.ok("Supplier linked to product successfully");
    }
}