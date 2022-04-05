package pl.agh.projektjava.Entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import pl.agh.projektjava.Exceptions.ExceptionWrongPesel;

@Entity
public class PersonalClient extends Client{
    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;
    
    String firstName;
    String lastName;
    String idCard;
    String pesel;

    // constructors

    public PersonalClient(){super();}
    public PersonalClient(Address address, String teleNumb, String email, String firstName, String lastName, String idCard, String pesel){
        super(teleNumb, email);
        setFirstName(firstName);setLastName(lastName);setIdCard(idCard);
        try{
            setPesel(pesel);
        }
        catch (ExceptionWrongPesel e){
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

    public void setFirstName(String firstName){this.firstName = firstName;}
    public String getFirstName(){return this.firstName;}

    public void setLastName(String lastName){this.lastName = lastName;}
    public String getLastName(){return this.lastName;}

    public void setIdCard(String idCard){this.idCard = idCard;}
    public String getIdCard(){return this.idCard;}

    public void setPesel(String pesel) throws ExceptionWrongPesel {
        if (Validation.ValPesel(pesel)){
            this.pesel = pesel;
        }
        else{
            throw new ExceptionWrongPesel("Incorrect pesel");
        }
    }
    public String getPesel(){return this.pesel;}
}
