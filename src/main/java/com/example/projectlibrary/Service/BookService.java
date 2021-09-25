package com.example.projectlibrary.Service;

import com.example.projectlibrary.Model.Book;

import java.util.List;

public interface BookService {
//    Xoá danh mục theo ID
void deleteById(Long id);
//    Tạo mới danh mục
    void save(Book book);
//    Cập nhật danh mục
    void update(Long id,Book book);
//   Lấy ra toàn bộ sách
    List<Book> findAll();
//    Lấy sách theo tên
    List<Book> findByBookName(String bookName);
//    Lấy sách theo ID
    Book findById(Long id);

}
