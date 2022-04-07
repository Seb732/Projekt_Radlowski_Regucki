package pl.agh.projektjava.Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.agh.projektjava.Exceptions.ExceptionWrongProdYear;
import pl.agh.projektjava.Exceptions.ExceptionWrongRegistNumb;
import pl.agh.projektjava.Exceptions.ExceptionWrongVIN;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarTest {

    @Test
    public void RegisterNewCar_FieldsGiven_ShouldCreateNewCar(){
        Car car = new Car();

        car.setBrand("Opel");
        car.setPriceRate(200);
        car.setModel("abcd");
        try{
            car.setProdYear("2001");
            car.setVIN("SY1SL65848Z411439");
            car.setRegistNumb("KR-XY67");
            car.setStatus(Car.Status.available);
        }
        catch (ExceptionWrongProdYear | ExceptionWrongVIN | ExceptionWrongRegistNumb e){
            assert true;
        }

        Assertions.assertEquals("Opel", car.getBrand());
        Assertions.assertEquals(200, car.getPriceRate());
        Assertions.assertEquals("abcd", car.getModel());
        Assertions.assertEquals("2001", car.getProdYear());
        Assertions.assertEquals("SY1SL65848Z411439", car.getVIN());
        Assertions.assertEquals("KR-XY67", car.getRegistNumb());
        Assertions.assertEquals(Car.Status.available, car.getStatus());
    }


}