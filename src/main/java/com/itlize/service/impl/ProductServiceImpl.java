package com.itlize.service.impl;

import com.itlize.dao.CategoryDao;
import com.itlize.dao.ProductDao;
import com.itlize.entity.Category;
import com.itlize.entity.Product;
import com.itlize.model.MessageResponse;
import com.itlize.service.CategoryService;
import com.itlize.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public void addNewProduct(Product product) {
        productDao.addNewProduct(product);
    }

    @Override
    @Transactional
    public ResponseEntity<?> getAllProduct() throws Exception{
        try {
            List<Product> products = productDao.getAllProduct();
            if (products.size() == 0) {
                return ResponseEntity.ok(new MessageResponse("No product in database"));
            }
            return ResponseEntity.ok(products);
        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("Get Product Failed", e);
        } catch (Exception e) {
            throw new Exception("Unknown error", e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> getProductByCategory(String sub_cname) throws Exception{
        try {
            Category category = categoryDao.getCategoryBySubcname(sub_cname);
            if (category == null) {
                return ResponseEntity.ok(new MessageResponse("Category doesn't exist"));
            }
            List<Product> products = productDao.getAllProductWithCategory(category.getCid());
            System.out.println("bbbb");
            return ResponseEntity.ok(products);
        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("Get Product Failed", e);
        } catch (Exception e) {
            throw new Exception("Unknown error", e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> getProductByPid(Long pid) throws Exception{
        try {
            Product product = productDao.getProductById(pid);
            if (product == null) {
                System.out.println("product");
                return ResponseEntity.ok(new MessageResponse("Product doesn't exist"));
            }
            return ResponseEntity.ok(product);
        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("Get Product Failed", e);
        } catch (Exception e) {
            throw new Exception("Unknown error", e);
        }
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }
}
