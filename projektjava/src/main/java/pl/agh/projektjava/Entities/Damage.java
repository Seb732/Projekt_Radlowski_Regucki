package pl.agh.projektjava.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Damage {

    static Long id = 0L;
    String description;
    Car car;
    LocalDate date;
    double price;

    public Damage(){}
    public Damage(String description, Car car, String date, double price){
        setId();setDescription(description);setCar(car);setDate(date);setPrice(price);
    }

    public void setId() {id++;}
    public Long getId() {return id;}

    public void setDescription(String description) {this.description = description;}
    public String getDescription() {return description;}

    public void setCar(Car car) {this.car = car;}
    public Car getCar() {return car;}

    public void setDate(String date) {this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));}
    public LocalDate getDate() {return date;}

    public void setPrice(double price) {this.price = price;}
    public double getPrice() {return price;}
}
