package pl.agh.projektjava;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import pl.agh.projektjava.Entities.Address;

@SpringBootApplication
class ProjektjavaApplicationTests {

	/**
	 * This test checks if method "equals" in class Address works properly
	 */
	@Test
	void addressEqualsAddress() {
		Address a1=new Address(1L, "Krakow", "31-152", "Warszawska", "153A", "12");
		Address a2=new Address(1L, "Krakow", "31-152", "Warszawska", "153A", "12");
		assertTrue(a1.equals(a2));
	}

}
