package com.itlize.service;

import com.itlize.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    // C
    void addNewProduct(Product product);

    // R
    ResponseEntity<?> getAllProduct() throws Exception;

    ResponseEntity<?> getProductByCategory(String sub_cname) throws Exception;

    ResponseEntity<?> getProductByPid(Long pid) throws Exception;

    // U
    void updateProduct(Product product);

    // D
    void deleteProduct(Product product);
}
