package pl.agh.projektjava.Entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;


import pl.agh.projektjava.Exceptions.ExceptionWrongPesel;

@Entity
public class PersonalClient extends Client{
    // @ManyToOne
    // @JoinColumn(name = "address_id")
    // Address address;
    @Column
    @Access(AccessType.FIELD)
    String firstName;
    @Column
    @Access(AccessType.FIELD)
    String lastName;
    @Column
    @Access(AccessType.FIELD)
    String idCard;
    
    String pesel;

    // constructors

    public PersonalClient(){super();}
    public PersonalClient(Address address,String teleNumb, String email, String firstName, String lastName, String idCard, String pesel){
        super(address ,teleNumb, email);
        setFirstName(firstName);setLastName(lastName);setIdCard(idCard);
        try{
            setPesel(pesel);
        }
        catch (ExceptionWrongPesel e){
            assert true; // do zrobienia
        }
    }

    // getters and setters
    // public Address getAddress() {
    //     return this.address;
    // }

    // public void setAddress(Address address) {
    //     this.address = address;
    // }

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
    @Column
    public String getPesel(){return this.pesel;}
}
