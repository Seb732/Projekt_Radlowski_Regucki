package pl.agh.projektjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.agh.projektjava.Entities.Address;
import pl.agh.projektjava.Entities.PersonalClient;
import pl.agh.projektjava.Exceptions.ExceptionWrongPesel;
import pl.agh.projektjava.Exceptions.ExceptionWrongTeleNumb;

@SpringBootApplication
public class PersonalClientTest {

    Address test_address = new Address(1L, "Krakow", "31-152", "Warszawska",
                                                "153A", "12");
    PersonalClient test_personalClient = new PersonalClient(test_address, "902-321-321",
            "abcde@gmail.com", "Jan", "Brzechwa", "E213",
            "01234576882");

    @Test
    public void registerNewPersonalClient_FieldsGiven_ShouldCreateNewPersonalClient(){
        Address address = new Address(1L, "Krakow", "31-152", "Warszawska",
                "153A", "12");

        assertThat(test_personalClient.getAddress(), samePropertyValuesAs(address));
        Assertions.assertEquals(test_personalClient.getTeleNumb(), "902-321-321");
        Assertions.assertEquals(test_personalClient.getEmail(), "abcde@gmail.com");
        Assertions.assertEquals(test_personalClient.getFirstName(), "Jan");
        Assertions.assertEquals(test_personalClient.getLastName(), "Brzechwa");
        Assertions.assertEquals(test_personalClient.getIdCard(), "E213");
        Assertions.assertEquals(test_personalClient.getPesel(), "01234576882");
    }

    @Test
    public void validatePersonalClientsEmail_IncorrectEmailGiven_ShouldThrowException(){
        Assertions.assertThrows(ExceptionWrongPesel.class, () -> test_personalClient.setPesel("123"));
    }
    @Test
    public void validatePersonalClientsTeleNumb_IncorrectTeleNumbGiven_ShouldThrowException(){
        Assertions.assertThrows(ExceptionWrongTeleNumb.class, () -> test_personalClient.setTeleNumb("abc"));
    }
    @Test
    public void validatePersonalClientsPesel_IncorrectPeselGiven_ShouldThrowException(){
        Assertions.assertThrows(ExceptionWrongPesel.class, () -> test_personalClient.setPesel("1o1"));
    }





}
