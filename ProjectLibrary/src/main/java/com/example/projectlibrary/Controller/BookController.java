package com.example.projectlibrary.Controller;

import com.example.projectlibrary.Model.Book;
import com.example.projectlibrary.Model.Category;
//import com.example.projectlibrary.Model.Libraryan;
import com.example.projectlibrary.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController extends BasicController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/book-full")
    public ResponseEntity<List<Book>> showAll(){
        List<Book> bookList=bookService.findAll();
        if (bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookList,HttpStatus.OK);
    }
    @GetMapping(value = "/searchname/{name}")
    public ResponseEntity<List<Book>> showFindByName(@PathVariable(value = "name") String bookName){
        bookName=bookName.trim();
        List<Book> bookList=bookService.findByBookName(bookName);
        if (bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookList,HttpStatus.OK);
    }
    @GetMapping(value = "/search/{id}")
    public ResponseEntity<Book> findById(@PathVariable(value = "id") Long id){
        Book book =bookService.findById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Book> insert(@RequestBody Book book){
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Book> updateById(@PathVariable(value = "id")Long id ,@RequestBody Book book){
        bookService.update(id,book);
        return new ResponseEntity<>(bookService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable(value = "id")Long id){
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/home")
    public String home(){
        return "This is Home Page";
    }
}
