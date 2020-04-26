package com.itlize.controller;


import com.itlize.entity.Category;
import com.itlize.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createNewCategory(@RequestBody Category category) throws Exception {
        return categoryService.addNewCategory(category);
    }

    @GetMapping(value = "/get/Category")
    public ResponseEntity<?> getCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping(value = "get/ByCname/{cname}")
    public ResponseEntity getByCname(@PathVariable("cname") String cname) throws Exception{
        return categoryService.getCategoryByCname(cname);
    }

    @GetMapping(value = "/get/BySubcname/{sub_cname}")
    public ResponseEntity getBySubcname(@PathVariable("sub_cname") String sub_cname) throws Exception{
        return categoryService.getCategoryBySubcname(sub_cname);
    }

    @PutMapping(value = "update")
    public ResponseEntity updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping(value = "delete")
    public ResponseEntity deleteCategory(@RequestBody Category category) {
        return categoryService.deleteCategory(category);
    }


}