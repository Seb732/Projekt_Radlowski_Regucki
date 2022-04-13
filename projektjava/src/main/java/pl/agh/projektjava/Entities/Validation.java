package pl.agh.projektjava.Entities;

import java.util.regex.*;

public abstract class Validation {

    public Validation(){}

    public static boolean ValTeleNumb(String teleNumb){return Pattern.compile("^[0-9]{3}-[0-9]{3}-[0-9]{3}$").matcher(teleNumb).matches();}
    public static boolean ValEmail(String email){return Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$").matcher(email).matches();}
    public static boolean ValPesel(String pesel){return Pattern.compile("^[0-9]{11}$").matcher(pesel).matches();}
    public static boolean ValNIP(String NIP){return Pattern.compile("^[0-9]{10}$").matcher(NIP).matches();}
    public static boolean ValREGON(String REGON){return Pattern.compile("^[0-9]{9}$").matcher(REGON).matches();}
    public static boolean ValProdYear(String prodYear){return Pattern.compile("^[0-9]{4}$").matcher(prodYear).matches();}
    public static boolean ValVIN(String VIN){return Pattern.compile("^\\w{17}$").matcher(VIN).matches();}
    public static boolean ValRegistNumb(String RegistNumb){return Pattern.compile("^[0-9A-Z]{2,3} [A-Z0-9]{4,5}$").matcher(RegistNumb).matches();}
    public static boolean ValPostalCode(String postalCode){return Pattern.compile("^[0-9]{2}-[0-9]{3}$").matcher(postalCode).matches();}


}
