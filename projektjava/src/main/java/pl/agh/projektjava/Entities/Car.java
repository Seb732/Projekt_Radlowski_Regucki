package pl.agh.projektjava.Entities;

import pl.agh.projektjava.Exceptions.ExceptionWrongProdYear;
import pl.agh.projektjava.Exceptions.ExceptionWrongRegistNumb;
import pl.agh.projektjava.Exceptions.ExceptionWrongVIN;

public class Car {

    public enum Status{available, unavailable, hired}

    static Long id = 0L;
    String brand;
    String prodYear;
    String VIN;
    String registNumb;
    double priceRate;
    Status status;

    public Car(){}
    public Car(String brand, String prodYear, String VIN, String registNumb, double priceRate, Status status){
        setId();setBrand(brand);setPriceRate(priceRate);
        try{
            setProdYear(prodYear);setVIN(VIN);setRegistNumb(registNumb);setStatus(status);
        }
        catch (ExceptionWrongProdYear | ExceptionWrongVIN | ExceptionWrongRegistNumb e){
            assert true; // do skonczenia
        }
    }

    public void setId(){id++;}
    public Long getId(){return id;}

    public void setBrand(String brand){this.brand = brand;}
    public String getBrand(){return this.brand;}

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

    public void setPriceRate(double priceRate){this.priceRate = priceRate;}
    public double getPriceRate(){return this.priceRate;}

    public void setStatus(Status status){this.status = status;}
    public Status getStatus(){return this.status;}

}
