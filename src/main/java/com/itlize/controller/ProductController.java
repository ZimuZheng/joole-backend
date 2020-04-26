package com.itlize.controller;


import com.itlize.entity.Product;
import com.itlize.model.MessageResponse;
import com.itlize.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
        return ResponseEntity.ok(new MessageResponse("Add successfully"));
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<?> getAllProduct() throws Exception{
        return productService.getAllProduct();
    }

    @GetMapping(value = "/get/byCategory/{sub_cname}")
    public ResponseEntity<?> getProductByCategory(@PathVariable("sub_cname") String sub_cname) throws Exception {
        return productService.getProductByCategory(sub_cname);
    }

    @GetMapping(value = "/get/byId/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long pid) throws Exception {
        return productService.getProductByPid(pid);
    }
}
