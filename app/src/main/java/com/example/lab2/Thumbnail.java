package com.example.lab2;

public class Thumbnail {
    public String name;
    public int img;
    Thumbnail(String name, int img){
        this.name = name;
        this.img = img;
    }
    public String getName(){
        return this.name;
    }
    public int getImg(){
        return this.img;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setImg(int img){
        this.img = img;
    }

}
