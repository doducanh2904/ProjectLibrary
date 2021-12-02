package com.example.projectlibrary.Controller;

import com.example.projectlibrary.Model.Category;
//import com.example.projectlibrary.Model.Libraryan;
import com.example.projectlibrary.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category")
public class CategoryController extends BasicController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/search/{id}")
    public ResponseEntity<Category> findById(@PathVariable(value = "id")Long id){
        Category category = categoryService.findById(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable(value = "id")Long id){
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Category> updateById(@PathVariable(value = "id")Long id ,@RequestBody Category category){
        categoryService.update(id, category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Category> insert(@Validated @RequestBody Category category, BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            for (final FieldError error:result.getFieldErrors()){
                System.out.println(errors.append("/"+error.getDefaultMessage()));
            }
        }
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
