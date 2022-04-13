package pl.agh.projektjava.Entities;

// import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


// import java.time.LocalDate;

// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.hamcrest.Matchers.samePropertyValuesAs;



@SpringBootTest
class RentOrderTest {

    @Test
    public void RegisterNewOrder_FieldsGiven_ShouldCreateNewOrder(){
        // RentOrder rentOrder = new RentOrder();

        // rentOrder.setId(1L);
        // rentOrder.setClient(new PersonalClient(1L, new Address(1L, "Krakow", "31-152", "Warszawska",
        //         "153A", "12"),"592-321-132", "dsadsa@gmail.com", "Jan",  "Kdsaas", "KDSA129", "01221090552"));
        // rentOrder.setCar(new Car("Opel", "2001", "abcd", "SY1SL65848Z411439",
        //         "KR-XY67", 200, Car.Status.available));
        // rentOrder.setRentStartDate("01-02-2022");
        // rentOrder.setRentEndDate("09-02-2022");
        // rentOrder.setStatus(rentOrder.status.active); // chyba do zmiany
        // rentOrder.setTotalCost();

        // Assertions.assertEquals(1L, rentOrder.getId());
        // assertThat(new PersonalClient(1L, new Address(1L, "Krakow", "31-152", "Warszawska",
        //         "153A", "12"),"592-321-132", "dsadsa@gmail.com", "Jan",  "Kdsaas", "KDSA129", "01221090552"), samePropertyValuesAs(rentOrder.getClient()));
        // assertThat(new Car("Opel", "2001", "abcd", "SY1SL65848Z411439",
        //         "KR-XY67", 200, Car.Status.available), samePropertyValuesAs(rentOrder.getCar()));
        // assertThat(LocalDate.of(2022, 2, 1), samePropertyValuesAs(rentOrder.getRentStartDate()));
        // assertThat(LocalDate.of(2022, 2, 9), samePropertyValuesAs(rentOrder.getRentEndDate()));
        // Assertions.assertEquals(Car.Status.hired, rentOrder.getStatus());
        // Assertions.assertEquals(1600, rentOrder.getTotalCost());
    }
}