package be.afelio.software_academy.pco.jdbc.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class _04_TestFindAllCityNamesByCountryNameOrderByCityName {

	@Test
	void testExistingCountry() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
		
		String[] cities = new String[] {"Brest", "Le Mans", "Toulon", "Toulouse"};
		List<String> expected = Arrays.asList(cities);
		List<String> actual = manager.findAllCityNamesByCountryNameOrderByCityName("France");
		
		assertEquals(expected, actual);
	}

	@Test
	void testNonExistingCountry() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
		
		List<String> expected = Collections.emptyList();
		List<String> actual = manager.findAllCityNamesByCountryNameOrderByCityName("xxxxx");
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testNullCountry() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
		
		List<String> expected = Collections.emptyList();
		List<String> actual = manager.findAllCityNamesByCountryNameOrderByCityName(null);
		
		assertEquals(expected, actual);
	}
}
