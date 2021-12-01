package com.example.projectlibrary.Service.impl;

import com.example.projectlibrary.Model.Student;
import com.example.projectlibrary.Repository.StudentRepository;
import com.example.projectlibrary.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    //    lấy ra toàn bộ data trong student
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
//    Lấy ra sinh viên theo ID
    public Student findById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    //    tìm kiếm student theo id, tên , gmail, lớp
    public List<Student> findByStudentSearch(String studentName){
        return studentRepository.findByStudentSearch(studentName);
    }

    //    xoá studet theo ID
    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

    //    thêm mới student
    public void save(Student student){
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.save(student);
    }

    //    update student
    public void update(Long id,Student student){
        Student student1 = studentRepository.findById(id).get();
        student1.setGmail(student.getGmail());
        student1.setStudentClass(student.getStudentClass());
        student1.setStudentName(student.getStudentName());
        student1.setSex(student.getSex());
        studentRepository.save(student1);
    }
}
