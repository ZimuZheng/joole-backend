package com.itlize.service;

import com.itlize.entity.Category;
import org.springframework.http.ResponseEntity;

import java.sql.SQLIntegrityConstraintViolationException;

public interface CategoryService {

    // C
    ResponseEntity<?> addNewCategory(Category category) throws Exception;

    // R
    ResponseEntity<?> getAllCategory();

    ResponseEntity<?> getCategoryByCname(String cname) throws Exception;

    ResponseEntity<?> getCategoryBySubcname(String sub_cname) throws Exception;

    // U
    ResponseEntity<?> updateCategory(Category category);

    // D
    ResponseEntity<?> deleteCategory(Category category);
}