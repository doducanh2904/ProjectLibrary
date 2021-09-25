package com.example.projectlibrary.Service;

import com.example.projectlibrary.Model.Category;

public interface CategoryService {
    void update(Long id, Category category);
    void save(Category category);
    void deleteById(Long id);
    Category findById(Long id);
}
