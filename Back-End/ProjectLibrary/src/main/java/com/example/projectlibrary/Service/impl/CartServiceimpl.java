package com.example.projectlibrary.Service.impl;

import com.example.projectlibrary.Model.Book;
import com.example.projectlibrary.Model.Cart;
import com.example.projectlibrary.Model.Student;
import com.example.projectlibrary.Repository.CartRepository;
import com.example.projectlibrary.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceimpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
//    @Autowired

//    Thêm mới cart
    public void saveCart(Long bookId, Long studentId){
        cartRepository.saveCart(bookId, studentId);
    }
    //    lấy ra toàn bộ data trong student
    public List<Cart> findAll(){
        return cartRepository.findAll();
    }
    //    Lấy ra sinh viên theo ID
    public Cart findById(Long id){
        return cartRepository.findById(id).orElse(null);
    }
    //    xoá studet theo ID
    public void deleteById(Long id){
        cartRepository.deleteById(id);
    }
}
