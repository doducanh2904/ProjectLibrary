package com.example.projectlibrary.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "user")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @NotEmpty
    private String studentName;
    @NotEmpty
    private String studentClass;
    @Email
    private String gmail;
    @NotEmpty
    private String sex;

    @NotEmpty
    private String username;


    @NotEmpty
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "studentConlection")
    @JsonIgnoreProperties("studentConlection")
    private Set<Cart> cartColection;



    @OneToMany(mappedBy = "borrowbConlection")
    @JsonIgnoreProperties("borrowbConlection")
    private Set<Borow> studentbColection;




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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public Student() { }

    public Student(Long studentId, String studentName, String studentClass, String gmail, String sex, Set<Cart> cartColection, Set<Borow> studentbColectio,String username,String password) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.gmail = gmail;
        this.sex = sex;
        this.cartColection = cartColection;
        this.studentbColection = studentbColection;
        this.username=username;
        this.password=password;
    }
}
