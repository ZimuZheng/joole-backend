package com.itlize.dao;

import com.itlize.entity.Category;

import java.util.List;

public interface CategoryDao {

    // C
    void addCategory(Category category);

    // R
    List<Category> getAllCategory();

    List<Category> getCategoryByCname(String cname);

    Category getCategoryBySubcname(String sub_cname);

    // U
    void updateCategory(Category category);

    // D
    void deleteCategory(Category category);
}
