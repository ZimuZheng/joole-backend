package com.itlize.entity;

import javax.persistence.*;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @Column(name="mid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;

    @Column(name="department")
    private String department;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="web")
    private String web;

    public Manufacturer() {
    }

    public Manufacturer(String department, String phone, String email, String web) {
        this.department = department;
        this.phone = phone;
        this.email = email;
        this.web = web;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
