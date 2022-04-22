package com.example.lab2;

abstract class Employee {
    protected String id;
    protected String name;
    protected boolean isManager;
    protected void setId(String id){
        this.id = id;
    }
    protected void setName(String name){
        this.name = name;
    }
    public abstract double TinhLuong();
    public abstract String ToString();
    protected String getFullName(){
        return this.name;
    }
    protected void setIsManager(boolean isManager){
        this.isManager = isManager;
    }
}
