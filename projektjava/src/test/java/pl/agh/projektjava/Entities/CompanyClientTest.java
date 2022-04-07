package pl.agh.projektjava.Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.agh.projektjava.Exceptions.ExceptionWrongEmail;
import pl.agh.projektjava.Exceptions.ExceptionWrongNIP;
import pl.agh.projektjava.Exceptions.ExceptionWrongRegon;
import pl.agh.projektjava.Exceptions.ExceptionWrongTeleNumb;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;


@SpringBootTest
class CompanyClientTest {

    @Test
    public void RegisterNewCompanyClient_FieldsGiven_ShouldCreateNewCompanyClient(){
        CompanyClient companyClient = new CompanyClient();

        companyClient.setId(1L);
        companyClient.setAddress(new Address(1L, "Krakow", "31-152", "Warszawska",
                "153A", "12"));
        try{
            companyClient.setEmail("abcde@gmail.com");
            companyClient.setTeleNumb("509-231-312");
            companyClient.setNIP("1234567890");
            companyClient.setREGON("123456789");
        }
        catch (ExceptionWrongEmail | ExceptionWrongTeleNumb | ExceptionWrongNIP | ExceptionWrongRegon e){
            assert true;
        }
        companyClient.setName("abcd");

        // fields assertions
        Assertions.assertEquals(1L, companyClient.getId());
        assertThat(companyClient.getAddress(), samePropertyValuesAs(new Address(1L, "Krakow",
                "31-152", "Warszawska",
                "153A", "12")));
        Assertions.assertEquals("abcde@gmail.com", companyClient.getEmail());
        Assertions.assertEquals("509-231-312", companyClient.getTeleNumb());
        Assertions.assertEquals("1234567890", companyClient.getNIP());
        Assertions.assertEquals("123456789", companyClient.getREGON());
        Assertions.assertEquals("abcd", companyClient.getName());

        // Exceptions
        Assertions.assertThrows(ExceptionWrongEmail.class, () -> companyClient.setEmail("123"));
        Assertions.assertThrows(ExceptionWrongTeleNumb.class, () -> companyClient.setTeleNumb("a"));
        Assertions.assertThrows(ExceptionWrongNIP.class, () -> companyClient.setNIP("1234"));
        Assertions.assertThrows(ExceptionWrongRegon.class, () -> companyClient.setREGON("1234"));
    }
}