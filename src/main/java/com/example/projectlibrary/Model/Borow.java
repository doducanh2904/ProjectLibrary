package com.example.projectlibrary.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrow")
public class Borow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowId;
//    private Long bookId;
//    private Long studentId;
//    private Long libraryanID;
    private String bookName;
    private int quantity;
    private Date borrowedDate;
    private Date payDate;
    private int borrowRole;



    public Borow(Long borrowId, String bookName, int quantity, Date borrowedDate, Date payDate, int borrowRole, Book borrowColection, Student borrowbConlection, Libraryan borrowlConlection) {
        this.borrowId = borrowId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.borrowedDate = borrowedDate;
        this.payDate = payDate;
        this.borrowRole = borrowRole;
        this.borrowColection = borrowColection;
        this.borrowbConlection = borrowbConlection;
        this.borrowlConlection = borrowlConlection;
    }

    @OneToOne
    @JoinColumn(name = "bookId",referencedColumnName = "bookId")
    @JsonIgnoreProperties("bookbColection")
    private Book borrowColection;

    @ManyToOne
    @JoinColumn(name = "studentId")
    @JsonIgnoreProperties("studentbColection")
    private Student borrowbConlection;

    @ManyToOne
    @JoinColumn(name = "libraryanId")
    @JsonIgnoreProperties("libraryanColection")
    private Libraryan borrowlConlection;

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
    public int getBorrowRole() {
        return borrowRole;
    }

    public void setBorrowRole(int borrowRole) {
        this.borrowRole = borrowRole;
    }

    public Book getBorrowColection() {
        return borrowColection;
    }

    public void setBorrowColection(Book borrowColection) {
        this.borrowColection = borrowColection;
    }

    public Student getBorrowbConlection() {
        return borrowbConlection;
    }

    public void setBorrowbConlection(Student borrowbConlection) {
        this.borrowbConlection = borrowbConlection;
    }

    public Libraryan getBorrowlConlection() {
        return borrowlConlection;
    }

    public void setBorrowlConlection(Libraryan borrowlConlection) {
        this.borrowlConlection = borrowlConlection;
    }

    public Borow(Long borrowId, String bookName, int quantity, Date borrowedDate, Date payDate, Book borrowColection, Student borrowbConlection, Libraryan borrowlConlection) {
        this.borrowId = borrowId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.borrowedDate = borrowedDate;
        this.payDate = payDate;
        this.borrowColection = borrowColection;
        this.borrowbConlection = borrowbConlection;
        this.borrowlConlection = borrowlConlection;
    }

    public Borow() {
    }
}
