package com.example.projectlibrary.Service.impl;

import com.example.projectlibrary.Model.Category;
import com.example.projectlibrary.Model.Student;
import com.example.projectlibrary.Repository.CategoryRepository;
import com.example.projectlibrary.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceimpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

//    @Autowired
    public Category findById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

        //    Xoá danh mục theo ID
    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }

    //    Tạo mới danh mục
    public void save(Category category){
        categoryRepository.save(category);
    }

    //    Cập nhật danh mục
    public void update(Long id,Category category){
        Category category1 = categoryRepository.findById(id).get();
        category1.setCategoryName(category.getCategoryName());
        category1.setTotal(category.getTotal());
        categoryRepository.save(category1);
    }
}
