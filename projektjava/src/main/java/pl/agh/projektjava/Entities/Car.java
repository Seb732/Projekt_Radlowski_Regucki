package pl.agh.projektjava.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.jmx.export.annotation.ManagedAttribute;

import pl.agh.projektjava.Exceptions.ExceptionWrongProdYear;

import pl.agh.projektjava.Exceptions.ExceptionWrongRegistNumb;
import pl.agh.projektjava.Exceptions.ExceptionWrongVIN;

@Entity
public class Car {

    public enum Status{available, unavailable, hired}
    @Id
    String VIN;
    String brand;
    String model;
    String prodYear;
    String registNumb;
    double priceRate;
    @Enumerated(EnumType.STRING)
    Status status;
    double longitude;
    double latitude;
    @OneToMany(mappedBy = "car")
    Set<Damage> damages;

    public Car(){}
    
    public Car(String brand, String prodYear, String VIN, String model,String registNumb, double priceRate, Status status){
        setBrand(brand);
        setPriceRate(priceRate);
        setModel(model);
        try{
            setProdYear(prodYear);
            setVIN(VIN);
            setRegistNumb(registNumb);
            setStatus(status);
        }
        catch (ExceptionWrongProdYear | ExceptionWrongVIN | ExceptionWrongRegistNumb e){
            assert true; // do skonczenia
        }
    }

    // getters and setters
    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    

    public void setProdYear(String prodYear) throws ExceptionWrongProdYear {
        if (Validation.ValProdYear(prodYear)) {
            this.prodYear = prodYear;
        } else {
            throw new ExceptionWrongProdYear("Incorrect production year");
        }
    }
    public String getProdYear(){return this.prodYear;}

    public void setVIN(String VIN) throws ExceptionWrongVIN {
        if (Validation.ValVIN(VIN)){
            this.VIN = VIN;
        }
        else{
            throw new ExceptionWrongVIN("Incorrect Vehicle Identification Number");
        }
    }
    public String getVIN(){return this.VIN;}

    public void setRegistNumb(String registNumb) throws ExceptionWrongRegistNumb {
        if (Validation.ValRegistNumb(registNumb)){
            this.registNumb = registNumb;
        }
        else{
            throw new ExceptionWrongRegistNumb("Incorrect registration number");
        }
    }
    public String getRegistNumb(){return this.registNumb;}

    public double getPriceRate() {
        return this.priceRate;
    }

    public void setPriceRate(double priceRate) {
        this.priceRate = priceRate;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    

}
