package pl.agh.projektjava.Entities;

import pl.agh.projektjava.Exceptions.ExceptionWrongPesel;

public class PersonalClient extends Client{

    String firstName;
    String lastName;
    String idCard;
    String pesel;

    public PersonalClient(){super();}
    public PersonalClient(Address address, String teleNumb, String email, String firstName, String lastName, String idCard, String pesel){
        super(address, teleNumb, email);
        setFirstName(firstName);setLastName(lastName);setIdCard(idCard);
        try{
            setPesel(pesel);
        }
        catch (ExceptionWrongPesel e){
            assert true; // do zrobienia
        }
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
