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

    @OneToMany(mappedBy = "booksConlection",cascade = CascadeType.ALL)
    @JsonManagedReference("booksConlection")
    private Set<Book> cartConlection;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentID",referencedColumnName = "studentId")
    @JsonIgnoreProperties("studentColection")
    private Student studentColection;

    public Cart(Long cartId, int quantity, String bookName, Set<Book> cartConlection, Student studentColection) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.bookName = bookName;
        this.cartConlection = cartConlection;
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

    public Set<Book> getCartConlection() {
        return cartConlection;
    }

    public void setCartConlection(Set<Book> cartConlection) {
        this.cartConlection = cartConlection;
    }

    public Student getStudentColection() {
        return studentColection;
    }

    public void setStudentColection(Student studentColection) {
        this.studentColection = studentColection;
    }
}
