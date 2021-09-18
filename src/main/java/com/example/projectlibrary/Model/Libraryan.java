package com.example.projectlibrary.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.DatabaseMetaData;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "libraryan")
public class Libraryan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long libraryanId;
    @NotEmpty(message = "name not null")
    private String libraryanName;
    @NotEmpty(message = "phone not null ")
    private String numberPhone;
    private String gmail;
    private String sex;
    private Date birthday;

    @OneToMany(mappedBy = "borrowlConlection")
    @JsonIgnoreProperties("borrowlConlection")
    private Set<Borow> libraryanColection;



    public Long getLibraryanId() {
        return libraryanId;
    }

    public void setLibraryanId(Long libraryanId) {
        this.libraryanId = libraryanId;
    }

    public String getLibraryanName() {
        return libraryanName;
    }

    public void setLibraryanName(String libraryanName) {
        this.libraryanName = libraryanName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public Libraryan(Long libraryanId, String libraryanName, String numberPhone, String gmail, String sex, Date birthday) {
        this.libraryanId = libraryanId;
        this.libraryanName = libraryanName;
        this.numberPhone = numberPhone;
        this.gmail = gmail;
        this.sex = sex;
        this.birthday = birthday;

    }

    public Libraryan() {
    }
}
