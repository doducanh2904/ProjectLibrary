package com.example.projectlibrary.Service.impl;


import com.example.projectlibrary.Model.Borow;
import com.example.projectlibrary.Repository.BorrowRepository;
import com.example.projectlibrary.Service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceimpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    //    thêm vào bảng mượn ( đặt sách )
    public void save(Borow borow) {
        borrowRepository.save(borow);
    }

    //    Lấy ra toàn bộ bảng mượn
    public List<Borow> findAll() {
        return borrowRepository.findAll();
    }

    //    Tra cứu lịch sử đật sách
    public List<Borow> findBorowByIdAndRole(Long studentId){
        return borrowRepository.findBorowByIdAndRole(studentId);
    }

    //    Không chấp nhận yêu cầu mượn sách
    public void updateAccept(Long borrowId){
        borrowRepository.updateAccept(borrowId);
    }

    //    Chấp nhận yêu cầu mượn sách
    public void updateNotAccept(Long borrowId){
        borrowRepository.updateNotAccept(borrowId);
    }

//    Lấy ra theo ID
    public Borow findById(Long borrowId){
        return borrowRepository.findById(borrowId).orElse(null);
    }
    // Show tất cả yêu cầu mượn sách
//    public List<Borow> findAllRequestBorow() {
//        return borrowRepository.findAllRequestBorow();
//    }
}
