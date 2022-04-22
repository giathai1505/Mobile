package com.example.lab2;

public class Dish {
    public String name;
    public Thumbnail thumbnail;
    public boolean isPromotion;
    public String getDishName(){
        return this.name;
    }
    public int getThumbnail(){
        return thumbnail.getImg();
    }
    public void setDishName(String name){
        this.name = name;
    }
    public void setIsPromotion (boolean isPromotion){
        this.isPromotion = isPromotion;
    }
    public void setThumbnail (String name, int img){
       this.thumbnail = new Thumbnail(name, img);
    }
}
