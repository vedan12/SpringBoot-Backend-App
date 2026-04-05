package com.example.SpringWithMongo.service;

import com.example.SpringWithMongo.entity.Category;
import com.example.SpringWithMongo.entity.Product;
import com.example.SpringWithMongo.entity.Supplier;
import com.example.SpringWithMongo.entity.Warranty;
import com.example.SpringWithMongo.repository.CategoryRepository;
import com.example.SpringWithMongo.repository.ProductRepository;
import com.example.SpringWithMongo.repository.SupplierRepository;
import com.example.SpringWithMongo.repository.WarrantyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    @Autowired private ProductRepository productRepo;
    @Autowired private CategoryRepository categoryRepo;
    @Autowired private WarrantyRepository warrantyRepo;

    // Business Logic: Save Warranty first, then link to Product
    public Product saveProduct(Product product) {
        if (product.getWarranty() != null) {
            warrantyRepo.save(product.getWarranty());
        }
        return productRepo.save(product);
    }

    // Business Logic: Resolve 1:N Relationship
    public void linkProductToCategory(String catId, String prodId) {
        Category category = categoryRepo.findById(catId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = productRepo.findById(prodId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        category.getProducts().add(product); // Add reference
        categoryRepo.save(category); // Update category document
    }

    public List<Product> getAllProducts() { return productRepo.findAll(); }

    public Product getProductById(String id) { return productRepo.findById(id).orElse(null); }

    public List<Product> searchByPriceRange(double min, double max) {
        return productRepo.findByPriceBetween(min, max);
    }

    public void deleteProduct(String id) { productRepo.deleteById(id); }

    public Category saveCategory(Category category) { return categoryRepo.save(category); }

    @Autowired private SupplierRepository supplierRepo;

    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    // Logic for Many-to-Many Link
    public void addSupplierToProduct(String supplierId, String productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Supplier supplier = supplierRepo.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        // Check if supplier already exists in the list to avoid duplicates
        if (!product.getSuppliers().contains(supplier)) {
            product.getSuppliers().add(supplier);
            productRepo.save(product); // Update the product document with new reference
        }
    }
}