package com.example.projectlibrary.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long categoryId;
    @NotEmpty(message = "Name not null")
    private String categoryName;
    private int total;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("category")
    private Set<Book> bookConlection;

//    public Set<Book> getBookConlection() {
//        return bookConlection;
//    }
//
//    public void setBookConlection(Set<Book> bookConlection) {
//        this.bookConlection = bookConlection;
//    }

    public Category() {    }

    public Category(Long categoryId, String categoryName, int total) {
        this.categoryName = categoryName;
        this.total = total;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
