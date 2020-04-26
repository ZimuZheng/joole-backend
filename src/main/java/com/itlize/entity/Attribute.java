package com.itlize.entity;

import javax.persistence.*;

@Entity
@Table(name = "attribute")
public class Attribute {

    @Id
    @Column(name="aid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    @Column(name="utype")
    private String utype;

    @Column(name="app")
    private String app;

    @Column(name="location")
    private String location;

    @Column(name="access")
    private String access;

    @Column(name="year")
    private int year;

    @Column(name="airflow")
    private int airflow;

    @Column(name="maxpower")
    private int maxpower;

    @Column(name="minpower")
    private int minpower;

    @Column(name="maxvac")
    private int maxvac;

    @Column(name="minvac")
    private int minvac;

    @Column(name="maxspeed")
    private int maxspeed;

    @Column(name="minspeed")
    private int minspeed;

    @Column(name="speeds")
    private int speeds;

    @Column(name="sound")
    private int sound;

    @Column(name="diameter")
    private int diameter;

    @Column(name="maxheight")
    private int maxheight;

    @Column(name="minheight")
    private int minheight;

    @Column(name="weight")
    private int weight;

    public Attribute () {}

    public Attribute(String utype, String app, String location, String access, int year, int airflow, int maxpower, int minpower, int maxvac, int minvac, int maxspeed, int minspeed, int speeds, int sound, int diameter, int maxheight, int minheight, int weight) {
        this.utype = utype;
        this.app = app;
        this.location = location;
        this.access = access;
        this.year = year;
        this.airflow = airflow;
        this.maxpower = maxpower;
        this.minpower = minpower;
        this.maxvac = maxvac;
        this.minvac = minvac;
        this.maxspeed = maxspeed;
        this.minspeed = minspeed;
        this.speeds = speeds;
        this.sound = sound;
        this.diameter = diameter;
        this.maxheight = maxheight;
        this.minheight = minheight;
        this.weight = weight;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAirflow() {
        return airflow;
    }

    public void setAirflow(int airflow) {
        this.airflow = airflow;
    }

    public int getMaxpower() {
        return maxpower;
    }

    public void setMaxpower(int maxpower) {
        this.maxpower = maxpower;
    }

    public int getMinpower() {
        return minpower;
    }

    public void setMinpower(int minpower) {
        this.minpower = minpower;
    }

    public int getMaxvac() {
        return maxvac;
    }

    public void setMaxvac(int maxvac) {
        this.maxvac = maxvac;
    }

    public int getMinvac() {
        return minvac;
    }

    public void setMinvac(int minvac) {
        this.minvac = minvac;
    }

    public int getMaxspeed() {
        return maxspeed;
    }

    public void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }

    public int getMinspeed() {
        return minspeed;
    }

    public void setMinspeed(int minspeed) {
        this.minspeed = minspeed;
    }

    public int getSpeeds() {
        return speeds;
    }

    public void setSpeeds(int speeds) {
        this.speeds = speeds;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getMaxheight() {
        return maxheight;
    }

    public void setMaxheight(int maxheight) {
        this.maxheight = maxheight;
    }

    public int getMinheight() {
        return minheight;
    }

    public void setMinheight(int minheight) {
        this.minheight = minheight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
