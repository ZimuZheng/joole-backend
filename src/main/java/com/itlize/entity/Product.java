package com.itlize.entity;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

    @Id
    @Column(name="pid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @ManyToOne
    @JoinColumn(name="cid")
    private Category categoryEntity;

    @ManyToOne
    @JoinColumn(name="mid")
    private Manufacturer manufacturerEntity;

    @OneToOne
    @JoinColumn(name="aid")
    private Attribute attributeEntity;

    @ManyToOne
    @JoinColumn(name="sid")
    private Sales salesEntity;

    @Column(name="manufacturer")
    private String manufacturer;

    @Column(name="series")
    private String series;

    @Column(name="model")
    private String model;

    @Column(name="detail")
    private String detail;

    @Column(name="document")
    private String document;

    public Product() {
    }

    public Product(String manufacturer, String series, String model, String detail, String document) {
        this.manufacturer = manufacturer;
        this.series = series;
        this.model = model;
        this.detail = detail;
        this.document = document;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Category getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(Category categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public Manufacturer getManufacturerEntity() {
        return manufacturerEntity;
    }

    public void setManufacturerEntity(Manufacturer manufacturerEntity) {
        this.manufacturerEntity = manufacturerEntity;
    }

    public Attribute getAttributeEntity() {
        return attributeEntity;
    }

    public void setAttributeEntity(Attribute attributeEntity) {
        this.attributeEntity = attributeEntity;
    }

    public Sales getSalesEntity() {
        return salesEntity;
    }

    public void setSalesEntity(Sales salesEntity) {
        this.salesEntity = salesEntity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
