package com.himanshu.achats;

/**
 * Created by Himanshu on 7/11/2017.
 */

public class Database {
    String type, brand, price, desc;

    public Database(){

    }
    public Database(String type, String brand, String price, String desc){
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
