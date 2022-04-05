package pl.agh.projektjava.Entities;

import javax.persistence.Id;

import javax.persistence.MappedSuperclass;

import pl.agh.projektjava.Exceptions.ExceptionWrongEmail;
import pl.agh.projektjava.Exceptions.ExceptionWrongTeleNumb;


@MappedSuperclass
public abstract class Client {

    @Id
    Long id;
    String teleNumb;
    String email;

    public Client() {}

    public Client( String teleNumb, String email) {
        try{
            setTeleNumb(teleNumb);setEmail(email);
        }
        catch (ExceptionWrongTeleNumb | ExceptionWrongEmail e){
            assert true; // do zrobienia
        }
    }

    public void setId(Long id)
    {
        this.id=id;
    }

    public Long getId(){return id;}


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
