package pl.agh.projektjava.Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.agh.projektjava.Exceptions.ExceptionWrongEmail;
import pl.agh.projektjava.Exceptions.ExceptionWrongPesel;
import pl.agh.projektjava.Exceptions.ExceptionWrongTeleNumb;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;



@SpringBootTest
class PersonalClientTest {

    @Test
    public void RegisterNewPersonalClient_FieldsGiven_ShouldCreateNewPersonalClient(){
        PersonalClient personalClient = new PersonalClient();

        personalClient.setId(1L);
        personalClient.setAddress(new Address(1L, "Krakow", "31-152", "Warszawska",
                "153A", "12"));
        try{
            personalClient.setTeleNumb("592-321-132");
            personalClient.setEmail("dsadsa@gmail.com");
            personalClient.setPesel("01221090552");
        }
        catch (ExceptionWrongTeleNumb | ExceptionWrongEmail | ExceptionWrongPesel e){
            assert true;
        }
        personalClient.setFirstName("Jan");
        personalClient.setLastName("Kdsaas");
        personalClient.setIdCard("KDSA129");

        Assertions.assertEquals(1L, personalClient.getId());
        assertThat(new Address(1L, "Krakow", "31-152", "Warszawska",
                "153A", "12"), samePropertyValuesAs(personalClient.getAddress()));
        Assertions.assertEquals("592-321-132", personalClient.getTeleNumb());
        Assertions.assertEquals("dsadsa@gmail.com", personalClient.getEmail());
        Assertions.assertEquals("01221090552", personalClient.getPesel());
        Assertions.assertEquals("Jan", personalClient.getFirstName());
        Assertions.assertEquals("Kdsaas", personalClient.getLastName());
        Assertions.assertEquals("KDSA129", personalClient.getIdCard());

        // Exceptions

        // Assertions.assertThrows(ExceptionWrongTeleNumb.class, () -> personalClient.setTeleNumb("3210102"));
        // Assertions.assertThrows(ExceptionWrongPesel.class, () -> personalClient.setPesel("0312321"));
        // Assertions.assertThrows(ExceptionWrongEmail.class, () -> personalClient.setEmail("321312"));

    }

}