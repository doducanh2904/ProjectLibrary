package com.example.projectlibrary.Service;

import com.example.projectlibrary.Model.Borow;
import com.example.projectlibrary.Model.Student;

import java.util.List;

public interface BorrowService {
    //    thêm vào bảng mượn ( đặt sách )
    void save(Borow borow);

    //    Lấy ra toàn bộ bảng mượn
    List<Borow> findAll();

    //    Tra cứu lịch sử đật sách
    List<Borow> findBorowByIdAndRole(Long studentId );

    //    Không chấp nhận yêu cầu mượn sách
    void updateAccept(Long borrowId);

    //    Chấp nhận yêu cầu mượn sách
    void updateNotAccept(Long borrowId);

//    Lấy ra theo ID
    Borow findById(Long borrowId);
//    // Show tất cả yêu cầu mượn sách
//    List<Borow> findAllRequestBorow();
}
