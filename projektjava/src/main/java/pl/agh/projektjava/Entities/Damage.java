package pl.agh.projektjava.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Damage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    @ManyToOne
    @JoinColumn(name = "car_id")
    Car car;
    LocalDate date;
    double price;
    @ManyToOne
    @JoinColumn(name="rent_id")
    RentOrder rentOrder;

    public Damage(){}
    public Damage(String description, Car car, String date, double price){
        setDescription(description);
        setCar(car);
        setDate(date);
        setPrice(price);
    }

    public void setId(Long id) {this.id=id;}
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
