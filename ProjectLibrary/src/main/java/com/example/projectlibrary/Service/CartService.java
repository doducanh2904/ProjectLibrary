package com.example.projectlibrary.Service;

import com.example.projectlibrary.Model.Book;
import com.example.projectlibrary.Model.Cart;
import com.example.projectlibrary.Model.Student;

import java.util.List;

public interface CartService {
    void saveCart(Long bookId, Long studentId);
    //    lấy ra toàn bộ data trong student
    List<Cart> findAll();
    //    Lấy ra sinh viên theo ID
    Cart findById(Long id);
    //    xoá studet theo ID
    void deleteById(Long id);
}
