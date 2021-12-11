package com.example.ms_shoppingmall;

import java.util.ArrayList;

public class Item {

    String name,brand,price;
    int image;
    ArrayList<Integer> detail_image;
    ArrayList<String> info;

    public Item(String name,String brand,String price,int image,ArrayList<Integer> detail_image,ArrayList<String> info){
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.image = image;
        this.detail_image = detail_image;
        this.info = info;
    }

    public String getName(){
        return name;
    }
    public String getBrand(){
        return brand;
    }
    public String getPrice(){
        return price;
    }
    public int getImage(){
        return image;
    }
    public ArrayList<Integer> getDetail_image(){
        return detail_image;
    }

    public ArrayList<String> getInfo() {
        return info;
    }
}
