package com.example.projectlibrary.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
//    private Long studentId;
//    private Long bookId;
    private int quantity;
    private String bookName;

    @OneToOne
    @JoinColumn(name = "bookId",referencedColumnName = "bookId")
    @JsonManagedReference
    private Book bookConlection;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId",referencedColumnName = "studentId")
    @JsonManagedReference
    private Student studentColection;

    public Cart(Long cartId, int quantity, String bookName, Book bookConlection, Student studentColection) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.bookName = bookName;
        this.bookConlection = bookConlection;
        this.studentColection = studentColection;
    }

    public Cart() {
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Student getStudentColection() {
        return studentColection;
    }

    public void setStudentColection(Student studentColection) {
        this.studentColection = studentColection;
    }
    public Book getBookConlection() {
        return bookConlection;
    }

    public void setBookConlection(Book bookConlection) {
        this.bookConlection = bookConlection;
    }
}
