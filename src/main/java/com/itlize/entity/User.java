package com.itlize.entity;


import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="fname")
    private String fname;

    @Column(name="lname")
    private String lname;

    @Column(name="title")
    private String title;

    @Column(name="password")
    private String password;

    @Column(name="password_hash")
    private String password_hash;

    public User() {

    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(String username, String fname, String lname, String email, String title, String password,String password_hash) {
        this.username = username;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.title = title;
        this.password = password;
        this.password_hash = password_hash;
    }


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "uid=" + uid +
//                ", userName='" + username + '\'' +
//                ", firstName='" + fname + '\'' +
//                ", lastName='" + lname + '\'' +
//                ", email='" + email + '\'' +
//                ", title='" + title + '\'' +
//                '}';
//    }
}
