package com.itlize.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
public class Category {

    @Id
    @Column(name="cid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(name="cname")
    private String cname;

    @Column(name="sub_cname")
    private String sub_cname;

//    @OneToMany(mappedBy = "Product")
//    private List<Product> products;

    public Category() {

    }

    public Category(String cname, String sub_cname) {
        this.cname = cname;
        this.sub_cname = sub_cname;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSub_cname() {
        return sub_cname;
    }

    public void setSub_cname(String sub_cname) {
        this.sub_cname = sub_cname;
    }

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

    //
//    @Override
//    public String toString() {
//        return "C{" +
//                "uid=" + cid +
//                ", userName='" + cname + '\'' +
//                ", firstName='" + sub_cname + '\'' +
//                '}';
//    }
}
