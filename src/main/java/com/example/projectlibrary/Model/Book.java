package com.example.projectlibrary.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookName;
    private int total;
    private int quantity;
    private String status;
    private String authorName;
    private Date date;
    private int numberPages;
    private Float borrowTime;
    private String imageBook;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("categoryConlection")
    private Category bookConlection;


    @OneToOne(mappedBy = "bookConlection")
    @JsonIgnoreProperties("bookConlection")
    private Cart cart;

//    private Cart booksConlection;

    public Borow getBorow() {
        return borow;
    }

    public void setBorow(Borow borow) {
        this.borow = borow;
    }

    @OneToOne(mappedBy = "borrowColection")
    @JsonIgnoreProperties("borrowColection")
    private Borow borow;

    public Book() {}

    public Book(Long bookId, String bookName, int total, int quantity, String status, String authorName, Date date, int numberPages, Float borrowTime) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.total = total;
        this.quantity = quantity;
        this.status = status;
        this.authorName = authorName;
        this.date = date;
        this.numberPages = numberPages;
        this.borrowTime = borrowTime;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public Float getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Float borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Book(Long bookId, String bookName, int total, int quantity, String status, String authorName, Date date, int numberPages, Float borrowTime, String imageBook, Borow borow, Cart cart) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.total = total;
        this.quantity = quantity;
        this.status = status;
        this.authorName = authorName;
        this.date = date;
        this.numberPages = numberPages;
        this.borrowTime = borrowTime;
        this.imageBook = imageBook;
        this.borow = borow;
        this.cart=cart;
    }

    public String getImageBook() {
        return imageBook;
    }

    public void setImageBook(String imageBook) {
        this.imageBook = imageBook;
    }

//    public Category getBookConlection() {
//        return bookConlection;
//    }
//
//    public void setBookConlection(Category bookConlection) {
//        this.bookConlection = bookConlection;
//    }
}
