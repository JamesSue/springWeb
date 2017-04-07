package com.springapp.pojo;

/**
 * Created by sulong on 2017/4/7.
 */
public class BookInfo {
    private  int id;
    private  String  name;
    private  float  price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
