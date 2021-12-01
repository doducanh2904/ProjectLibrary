package com.example.projectlibrary.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

//    @ManyToOne
//    @JoinColumn(name = "categoryId")
//    @JsonIgnoreProperties("categoryConlection")
//    private Category bookConlection;


    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("bookConlection")
    private Category category;


    @OneToMany(mappedBy = "bookConlection")
    @JsonIgnoreProperties("bookConlection")
    private Set<Cart> cartColectionBook;


    @OneToOne(mappedBy = "borrowColection")
    @JsonIgnoreProperties("borrowColection")
    private Borow borow;

//    @ManyToMany
//    @JoinTable(name = "developer_project",
//            joinColumns = @JoinColumn(name = "book_id"),
//            inverseJoinColumns = @JoinColumn(name = "borrow_id"))
//    private Set<Borow> borrow;


    public Book() {}

    public Book( String bookName, int total, int quantity, String status, String authorName, Date date, int numberPages, Float borrowTime, String imageBook, Category category, Borow borow) {
//        this.bookId = bookId;
        this.bookName = bookName;
        this.total = total;
        this.quantity = quantity;
        this.status = status;
        this.authorName = authorName;
        this.date = date;
        this.numberPages = numberPages;
        this.borrowTime = borrowTime;
        this.imageBook = imageBook;
        this.category = category;
//        this.cart = cart;
        this.borow = borow;
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
    public String getImageBook() {
        return imageBook;
    }

    public void setImageBook(String imageBook) {
        this.imageBook = imageBook;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    //    public Borow getBorow() {
//        return borow;
//    }
//
//    public void setBorow(Borow borow) {
//        this.borow = borow;
//    }

//
//    public Category getBookConlection() {
//        return bookConlection;
//    }
//
//    public void setBookConlection(Category bookConlection) {
//        this.bookConlection = bookConlection;
//    }
}
