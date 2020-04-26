package com.itlize.entity;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @Column(name="sid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="web")
    private String web;

    public Sales() {
    }

    public Sales(String name, String phone, String email, String web) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.web = web;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
