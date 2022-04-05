package pl.agh.projektjava.Entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import pl.agh.projektjava.Entities.Car.Status;

public class RentOrder {

    Long id;
    Client client;
    Car car;
    LocalDate rentStartDate;
    LocalDate rentEndDate;
    Status status;
    double totalCost;
    // ?list

    // constructors
    public RentOrder(){}
    public RentOrder(Client client, Car car, String rentStartDate, String rentEndDate, Status status){
        setClient(client);
        setCar(car);
        setRentStartDate(rentStartDate);
        setRentEndDate(rentEndDate);
        setStatus(status);
    }

    // getters and setters
    
    public void setId(Long id){this.id=id;}
    public Long getId() {return id;}

    public void setClient(Client client) {this.client = client;}
    public Client getClient() {return client;}

    public void setCar(Car car) {this.car = car;}
    public Car getCar() {return car;}

    public void setRentStartDate(String rentStartDate) {
        this.rentStartDate = LocalDate.parse(rentStartDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    public LocalDate getRentStartDate() {return rentStartDate;}

    public void setRentEndDate(String rentEndDate) {
        this.rentEndDate = LocalDate.parse(rentEndDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    public LocalDate getRentEndDate() {return rentEndDate;}

    public void setStatus(Status status) {this.status = status;}
    public Status getStatus() {return status;}

    public void setTotalCost() {
        this.totalCost = TimeUnit.DAYS.convert(Math.abs(java.util.Date.from(rentEndDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant()).getTime()
                        -
                java.util.Date.from(rentStartDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant()).getTime()
                ),  TimeUnit.MILLISECONDS) * car.priceRate;}
    public double getTotalCost() {return totalCost;}
}
