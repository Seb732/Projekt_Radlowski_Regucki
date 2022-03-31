package pl.agh.projektjava.Entities;

import pl.agh.projektjava.Exceptions.ExceptionWrongNIP;
import pl.agh.projektjava.Exceptions.ExceptionWrongRegon;

public class CompanyClient extends Client{

    String name;
    String NIP;
    String REGON;

    public CompanyClient(){super();}
    public CompanyClient(Address address, String teleNumb, String email, String name, String NIP, String REGON){
        super(address, teleNumb, email);
        setName(name);
        try{
            setNIP(NIP);setREGON(REGON);
        }
        catch (ExceptionWrongNIP | ExceptionWrongRegon e){
            assert true; // do zrobienia
        }
    }

    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}

    public void setNIP(String NIP) throws ExceptionWrongNIP {
        if (Validation.ValNIP(NIP)){
            this.NIP = NIP;
        }
        else{
            throw new ExceptionWrongNIP("Incorrect NIP");
        }
    }
    public String getNIP(){return this.NIP;}

    public void setREGON(String REGON) throws ExceptionWrongRegon {
        if (Validation.ValREGON(REGON)){
            this.REGON = REGON;
        }
        else{
            throw new ExceptionWrongRegon("Incorrect REGON");
        }
    }
    public String getREGON(){return this.REGON;}

}
