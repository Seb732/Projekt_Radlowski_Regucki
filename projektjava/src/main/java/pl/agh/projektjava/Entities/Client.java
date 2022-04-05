package pl.agh.projektjava.Entities;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



import pl.agh.projektjava.Exceptions.ExceptionWrongEmail;
import pl.agh.projektjava.Exceptions.ExceptionWrongTeleNumb;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(javax.persistence.AccessType.FIELD)
    Long id;
    @ManyToOne
    @JoinColumn(name = "address_id")
    @Access(javax.persistence.AccessType.FIELD)
    Address address;
    String teleNumb;
    String email;
    @Column
    @Access(AccessType.FIELD)
    double balance;

    // constructors

    public Client() {}

    public Client(Address address, String teleNumb, String email) {
        try{
            setAddress(address);
            setTeleNumb(teleNumb);
            setEmail(email);
        }
        catch (ExceptionWrongTeleNumb | ExceptionWrongEmail e){
            assert true; // do zrobienia
        }
    }

    // getters and setters
    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
    @Column
    public String getTeleNumb(){return this.teleNumb;}

    public void setEmail(String email) throws ExceptionWrongEmail {
        if (Validation.ValEmail(email)){
            this.email = email;
        }
        else{
            throw new ExceptionWrongEmail("Incorrect email");
        }
    }
    @Column
    public String getEmail(){return this.email;}

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
