
package pl.agh.projektjava.Entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import pl.agh.projektjava.Repos.CarRepo;
import pl.agh.projektjava.Services.CarServices;


@Entity
public class RentOrder {
    public enum OrderStatus{active,finished}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @ManyToOne
    @JoinColumn(name = "car_vin")
    Car car;

    @Column
    @Access(AccessType.FIELD)
    LocalDate rentStartDate;
    
    @Column
    @Access(AccessType.FIELD)
    LocalDate rentEndDate;

    @Enumerated(EnumType.STRING)
    OrderStatus status;

    double totalCost;



    // constructors
    public RentOrder(){}
    public RentOrder(Client client, Car car, LocalDate rentStartDate, LocalDate rentEndDate, OrderStatus status){
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

    public void setCar(Car car) 
    {
        this.car = car;
    }
    public Car getCar() {return car;}

    // public void setRentStartDate(String rentStartDate) {
    //     this.rentStartDate = LocalDate.parse(rentStartDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    // }

    // public LocalDate getRentStartDate() {return rentStartDate;}

    // public void setRentEndDate(String rentEndDate) {
    //     this.rentEndDate = LocalDate.parse(rentEndDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    // }
    
    
    // public LocalDate getRentEndDate() {return rentEndDate;}

    public LocalDate getRentStartDate() {
        return this.rentStartDate;
    }

    public void setRentStartDate(LocalDate rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public LocalDate getRentEndDate() {
        return this.rentEndDate;
    }

    public void setRentEndDate(LocalDate rentEndDate) {
        this.rentEndDate = rentEndDate;
    }


    public void setStatus(OrderStatus status) {this.status = status;}
    public OrderStatus getStatus() {return status;}

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
