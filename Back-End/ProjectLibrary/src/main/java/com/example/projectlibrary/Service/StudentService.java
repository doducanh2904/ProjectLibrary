package com.example.projectlibrary.Service;

import com.example.projectlibrary.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface StudentService {

//    lấy ra toàn bộ data trong student
    List<Student> findAll();
//    Lấy ra sinh viên theo ID
    Student findById(Long id);

//    tìm kiếm student theo id, tên , gmail, lớp
    List<Student> findByStudentSearch(String studentName);

//    xoá studet theo ID
    void deleteById(Long id);

//    thêm mới student
    void save(Student student);

//    update student
    void update(Long id,Student student);
}
