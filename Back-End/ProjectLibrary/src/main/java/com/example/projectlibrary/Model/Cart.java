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
    private String bookName;

//    @OneToOne
//    @JoinColumn(name = "bookId",referencedColumnName = "bookId")
//    @JsonManagedReference
//    private Book bookConlection;

    @ManyToOne
    @JoinColumn(name = "booId")
    @JsonIgnoreProperties("cartColectionBook")
    private Book bookConlection;



    @ManyToOne
    @JoinColumn(name = "studentId")
    @JsonIgnoreProperties("cartColection")
    private Student studentConlection;

    public Cart() { }

    public Cart(Long cartId, int quantity, String bookName, Book bookConlection, Student studentConlection) {
        this.cartId = cartId;
//        this.quantity = quantity;
        this.bookName = bookName;
        this.bookConlection = bookConlection;
        this.studentConlection=studentConlection;
    }



    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Book getBookConlection() {
        return bookConlection;
    }

    public void setBookConlection(Book bookConlection) {
        this.bookConlection = bookConlection;
    }

    public Student getStudentConlection() {
        return studentConlection;
    }

    public void setStudentConlection(Student studentConlection) {
        this.studentConlection = studentConlection;
    }
}
