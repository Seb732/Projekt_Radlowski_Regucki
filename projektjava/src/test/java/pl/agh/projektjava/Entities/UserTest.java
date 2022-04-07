package pl.agh.projektjava.Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.agh.projektjava.Exceptions.ExceptionWrongEmail;
import pl.agh.projektjava.Exceptions.ExceptionWrongPassword;
import pl.agh.projektjava.Exceptions.ExceptionWrongTeleNumb;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;


@SpringBootTest
class UserTest {

    @Test
    public void RegisterNewUser_FieldsGiven_ShouldCreateNewUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        user.setAddress(new Address(1L, "Krakow", "31-152", "Warszawska",
                "153A", "12"));
        user.setRole("admin");
        user.setTeleNumb("509-231-312");
        user.setEmail("abcde@gmail.com");
        user.setPassword("Kdsada123");

        Assertions.assertEquals(1L, user.getId());
        Assertions.assertEquals("Jan", user.getFirstName());
        Assertions.assertEquals("Kowalski", user.getLastName());
        assertThat(new Address(1L, "Krakow", "31-152", "Warszawska",
                "153A", "12"), samePropertyValuesAs(user.getAddress()));
        Assertions.assertEquals("admin", user.getRole());
        Assertions.assertEquals("509-231-312", user.getTeleNumb());
        Assertions.assertEquals("abcde@gmail.com", user.getEmail());
        Assertions.assertEquals("Kdsada123", user.getPassword());

        Assertions.assertThrows(ExceptionWrongTeleNumb.class, () -> user.setTeleNumb("212-21aa0"));
        Assertions.assertThrows(ExceptionWrongEmail.class, () -> user.setEmail("1@2.pl0"));
        Assertions.assertThrows(ExceptionWrongPassword.class, () -> user.setPassword("123"));
    }
}