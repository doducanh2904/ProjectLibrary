package com.example.projectlibrary.Repository;

import com.example.projectlibrary.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book,Long> {
}
