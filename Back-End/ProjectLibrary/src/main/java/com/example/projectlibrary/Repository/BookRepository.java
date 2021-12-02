package com.example.projectlibrary.Repository;

import com.example.projectlibrary.Model.Book;
//import com.example.projectlibrary.Model.Libraryan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository  extends JpaRepository<Book,Long> {
//    @Query(value = "SELECT * FROM book JOIN category ON book.categoy_id = category.category_id WHERE book_name LIKE %?1% OR category.category_name LIKE %?1% OR book_id LIKE %?1%",nativeQuery = true)
//    List<Book> findByBookName(String bookName);
    @Query(value = " SELECT * FROM book inner join category on book.category_id=category.category_id WHERE book.book_name LIKE %?1% OR category.`category_name` LIKE %?1% OR book.book_id LIKE %?1%" ,nativeQuery = true)
    List<Book> findByBookName(String bookName);

}



