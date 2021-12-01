package com.example.projectlibrary.Repository;

import com.example.projectlibrary.Model.Book;
import com.example.projectlibrary.Model.Cart;
import com.example.projectlibrary.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//@Modifying
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Transactional
    @Modifying
    @Query(value = " INSERT INTO cart (book_name, book_id, student_id) SELECT book.`book_name`, book.`book_id`,student.`student_id` FROM book,student WHERE book_id= ?1 and student_id=?2 ",nativeQuery = true)
    void saveCart(Long bookId, Long studentId);
}

