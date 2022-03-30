package pl.agh.projektjava.Entities;

import pl.agh.projektjava.Exceptions.ExceptionWrongEmail;
import pl.agh.projektjava.Exceptions.ExceptionWrongTeleNumb;

import javax.persistence.Entity;


public abstract class Client {

    static Long id = 0L;
    Address address;
    String teleNumb;
    String email;

    public Client() {}

    public Client(Address address, String teleNumb, String email) {
        setId();setAddress(address);
        try{
            setTeleNumb(teleNumb);setEmail(email);
        }
        catch (ExceptionWrongTeleNumb | ExceptionWrongEmail e){
            assert true; // do zrobienia
        }
    }

    public void setId(){id++;}
    public Long getId(){return id;}

    public void setAddress(Address address){this.address = address;}
    public Address getAddress(){return this.address;}

    public void setTeleNumb(String teleNumb) throws ExceptionWrongTeleNumb {
        if (Validation.ValTeleNumb(teleNumb)){
            this.teleNumb = teleNumb;
        }
        else{
            throw new ExceptionWrongTeleNumb("Incorrect phone number");
        }

    }
    public String getTeleNumb(){return this.teleNumb;}

    public void setEmail(String email) throws ExceptionWrongEmail {
        if (Validation.ValEmail(email)){
            this.email = email;
        }
        else{
            throw new ExceptionWrongEmail("Incorrect email");
        }
    }
    public String getEmail(){return this.email;}
}
