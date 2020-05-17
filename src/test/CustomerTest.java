package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matcher.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;

import main.*;

class CustomerTest {
	private static Customer customer;
	
	@BeforeEach
	void setup() {
	  customer = new Customer("joe");
      Movie m1 = new Movie("movie1", 1);
      Movie m2 = new Movie("movie2", 2);
      Rental r1 = new Rental(m1, 10);
      Rental r2 = new Rental(m2, 5);
		
      customer.addRental(r1);
      customer.addRental(r2);
	}
	
	@Test
	void testStatement() {        
		String result = customer.statement();
		String expected_result = "Rental Record for joe\n" + 
				"\tTitle\t\tDays\tAmount\n" + 
				"\tmovie1\t\t10\t30.0\n" + 
				"\tmovie2\t\t5\t4.5\n" + 
				"Amount owed is 34.5\n" + 
				"You earned 3 frequent renter points";
		
		assertEquals(result,expected_result);
	}

}
