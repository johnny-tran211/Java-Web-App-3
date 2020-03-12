/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangtd.car;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class CarDTO implements Serializable{
    private int id;
    private String carName;
    private String color;
    private int year;
    private String category;
    private double price;
    private int quantity;
    private  double total;

    public CarDTO(int id, String carName, String color, int year, String category, double price, int quantity) {
        this.id = id;
        this.carName = carName;
        this.color = color;
        this.year = year;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
    public CarDTO(String carName, String category, int quantity, double price, double total) {
        this.carName = carName;
        this.category = category;
        this.price = price;
        this.total = total;
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
