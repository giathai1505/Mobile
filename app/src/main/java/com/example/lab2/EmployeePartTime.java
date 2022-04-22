package com.example.lab2;

public class EmployeePartTime extends Employee{
    @Override
    public double TinhLuong(){
        return 150.00;
    }
    @Override
    public String ToString(){
        return String.format("%s - %s --> PartTime = %s", super.id, super.name, TinhLuong());
    }

}
