package pl.agh.projektjava.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import pl.agh.projektjava.Exceptions.ExceptionWrongProdYear;
import pl.agh.projektjava.Exceptions.ExceptionWrongRegistNumb;
import pl.agh.projektjava.Exceptions.ExceptionWrongVIN;

@Entity
public class Car {

    public enum Status{available, unavailable, hired}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String brand;
    String prodYear;
    String VIN;
    String registNumb;
    double priceRate;
    String status;
    double longitude;
    double latitude;

    public Car(){}
    
    public Car(String brand, String prodYear, String VIN, String registNumb, double priceRate, String status){
        setBrand(brand);
        setPriceRate(priceRate);
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
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

}
