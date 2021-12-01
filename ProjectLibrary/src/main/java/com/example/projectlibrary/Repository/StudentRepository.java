package com.example.projectlibrary.Repository;

import com.example.projectlibrary.Model.Book;
//import com.example.projectlibrary.Model.Libraryan;
import com.example.projectlibrary.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value = "SELECT * FROM student WHERE student_id LIKE %?1% OR gmail LIKE %?1% OR student_name LIKE %?1% OR student_class LIKE %?1%",nativeQuery = true)
    List<Student> findByStudentSearch(String studentName);

    Student findByUsername(String username);
    List<Student> findAll();

}
