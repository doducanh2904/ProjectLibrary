package com.example.projectlibrary.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    private String studentClass;
    private String gmail;
    private String sex;


    @OneToOne(mappedBy = "studentColection")
    @JsonManagedReference
    private Cart cart;

    @OneToMany(mappedBy = "borrowbConlection")
    @JsonIgnoreProperties("borrowbConlection")
    private Set<Borow> studentbColection;


    public Set<Borow> getStudentbColection() {
        return studentbColection;
    }

    public void setStudentbColection(Set<Borow> studentbColection) {
        this.studentbColection = studentbColection;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Student(Long studentId, String studentName, String studentClass, String gmail, String sex, Cart cart) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.gmail = gmail;
        this.sex = sex;
        this.cart = cart;
    }

    public Student() {
    }
}
