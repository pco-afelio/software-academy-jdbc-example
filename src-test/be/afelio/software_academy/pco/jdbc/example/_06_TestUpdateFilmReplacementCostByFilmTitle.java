package be.afelio.software_academy.pco.jdbc.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class _06_TestUpdateFilmReplacementCostByFilmTitle {

	@Test
	void testExistingTitle() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
		
		Random random = new Random();
		int digits = random.nextInt(100);
		int decimals = random.nextInt(100);
		
		Float expected = Float.parseFloat(String.format("%s.%s", digits, decimals));
		assertTrue(manager.updateFilmReplacementCostByFilmTitle("Academy Dinosaur", expected));
		Float actual = manager.findOneFilmReplacementCostByFilmTitle("Academy Dinosaur");
		assertEquals(expected, actual);
	}

	@Test
	void testNonExistingTitle() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
		
		assertFalse(manager.updateFilmReplacementCostByFilmTitle("xxxxx", 20f));
	}
}
