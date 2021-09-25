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
    @GeneratedValue()

    private Long categoryId;
    @NotEmpty(message = "Name not null")
    private String categoryName;
    private int total;

    public Category() {    }

    public Category(Long categoryId, String categoryName, int total) {
        this.categoryId = categoryId;
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
    @OneToMany(mappedBy = "bookConlection",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("bookConlection")
    private Set<Book> categoryConlection;
}
