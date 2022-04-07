package pl.agh.projektjava.Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.agh.projektjava.Exceptions.ExceptionWrongPostalCode;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressTest {
    @Test
    public void RegisterNewAdressObject_FieldsGiven_ShouldCreateNewAdressObject(){
        Address address = new Address();
        address.setId(1L);
        address.setCity("Krakow");
        address.setPostalCode("31-152");
        address.setStreet("Warszawska");
        address.setBuildingNumb("153A");
        address.setLocalNumb("12");

        Assertions.assertEquals(1L, address.getId());
        Assertions.assertEquals("Krakow", address.getCity());
        Assertions.assertEquals("31-152", address.getPostalCode());
        Assertions.assertEquals("Warszawska", address.getStreet());
        Assertions.assertEquals("153A", address.getBuildingNumb());
        Assertions.assertEquals("12", address.getLocalNumb());

        // Exception check
        Assertions.assertThrows(ExceptionWrongPostalCode.class, () -> address.setPostalCode("abc"));
    }
}