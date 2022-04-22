package com.example.lab2;

public class EmployeeFullTime extends Employee{

    @Override
    public double TinhLuong() {
        return 500.00;
    }
    @Override
    public String ToString(){
        return  String.format("%s - %s --> FullTime = %s", super.id, super.name, TinhLuong());
    }
}
