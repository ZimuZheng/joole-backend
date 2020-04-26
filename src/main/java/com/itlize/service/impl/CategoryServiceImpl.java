package com.itlize.service.impl;

import com.itlize.dao.CategoryDao;
import com.itlize.entity.Category;
import com.itlize.model.MessageResponse;
import com.itlize.service.CategoryService;
import com.itlize.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public ResponseEntity<?> addNewCategory(Category category) throws Exception {
        try {
            if (categoryDao.getCategoryBySubcname(category.getSub_cname()) != null) {
                return new ResponseEntity<>(new MessageResponse("This category is already exist."),
                        HttpStatus.NOT_ACCEPTABLE);
            }
            categoryDao.addCategory(category);
            return ResponseEntity.ok(category);

        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("The information provided cannot be accepted", e);

        } catch (Exception e) {
            throw new Exception("Something went wrong", e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> getAllCategory() {
        List<Category> categoryList = categoryDao.getAllCategory();
        List<String> categoryname = new ArrayList<String>();

        if (categoryList.size() == 0) {
            return ResponseEntity.ok(new MessageResponse("No Category in Database"));
        }

        for (int i=0; i<categoryList.size(); i++) {
            if (categoryname.contains(categoryList.get(i).getCname()) || categoryList.get(i).getCname() == null) {
                continue;
            } else {
                categoryname.add(categoryList.get(i).getCname());
            }
        }
        return ResponseEntity.ok(categoryname);
    }

    @Override
    @Transactional
    public ResponseEntity<?> getCategoryByCname(String cname) throws Exception{
        try {
            List<Category> categories =  categoryDao.getCategoryByCname(cname);
            if (categories.size() == 0) {
                return new ResponseEntity<>(new MessageResponse("This category doesn't exist."),
                        HttpStatus.NOT_ACCEPTABLE);
            }
            return ResponseEntity.ok(categories);

        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("The information provided cannot be accepted", e);

        } catch (Exception e) {
            throw new Exception("Something went wrong", e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> getCategoryBySubcname(String sub_cname) throws Exception {
        try {
            Category category = categoryDao.getCategoryBySubcname(sub_cname);
            if (category == null) {
                return new ResponseEntity<>(new MessageResponse("This subcategory doesn't exist."),
                        HttpStatus.NOT_ACCEPTABLE);
            }
            return ResponseEntity.ok(category);

        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("The information provided cannot be accepted", e);

        } catch (Exception e) {
            throw new Exception("Something went wrong", e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateCategory (Category category){
        categoryDao.updateCategory(category);
        return ResponseEntity.ok(new MessageResponse("Update Category"));
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteCategory(Category category) {
        categoryDao.deleteCategory(category);
        return ResponseEntity.ok(new MessageResponse("Delete Category"));
    }
}