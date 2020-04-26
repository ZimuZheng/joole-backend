package com.itlize.dao;

import com.itlize.entity.Product;

import java.util.List;

public interface ProductDao {

    // C
    void addNewProduct(Product product);

    // R
    List<Product> getAllProduct();

    List<Product> getAllProductWithCategory(Long cid);

    Product getProductById(Long pid);

    // U
    void updateProduct(Product product);

    // D
    void deleteProduct(Product product);
}
