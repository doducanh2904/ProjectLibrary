package com.example.projectlibrary.Service.impl;

import com.example.projectlibrary.Model.Book;
import com.example.projectlibrary.Repository.BookRepository;
import com.example.projectlibrary.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceimpl implements BookService {
    @Autowired

    private BookRepository bookRepository;
//    @Autowired
//    Xoá danh mục theo ID
    @Autowired
    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    public Book findById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }

    //    Tạo mới danh mục
//    @Autowired
    public void save(Book book){
        bookRepository.save(book );
    }
    //    Cập nhật danh mục
    public void update(Long id,Book book){
        Book book1 = bookRepository.findById(id).get();
        book1.setBookName(book.getBookName());
        book1.setImageBook(book.getImageBook());
        book1.setAuthorName(book.getAuthorName());
        book1.setBorrowTime(book.getBorrowTime());
        book1.setDate(book.getDate());
        book1.setNumberPages(book.getNumberPages());
        book1.setQuantity(book.getQuantity());
        book1.setStatus(book.getStatus());
        book1.setTotal(book.getTotal());
        bookRepository.save(book1);
    }
    //   Lấy ra toàn bộ sách


    //    Lấy sách theo tên
    public List<Book> findByBookName(String bookName){
        return bookRepository.findByBookName(bookName);
    }


}
