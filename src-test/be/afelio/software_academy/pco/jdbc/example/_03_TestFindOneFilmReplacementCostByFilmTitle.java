package be.afelio.software_academy.pco.jdbc.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _03_TestFindOneFilmReplacementCostByFilmTitle {

	@Test
	void testExistingTitle() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
		
		Float expected = 14.99f;
		Float actual = manager.findOneFilmReplacementCostByFilmTitle("Chamber Italian");
		assertEquals(expected, actual);
	}
	
	@Test
	void testNonExistingTitle() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
		
		Float expected = null;
		Float actual = manager.findOneFilmReplacementCostByFilmTitle("xxxxx");
		assertEquals(expected, actual);
	}
	
	@Test
	void testEmptyTitle() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
		
		Float expected = null;
		Float actual = manager.findOneFilmReplacementCostByFilmTitle("");
		assertEquals(expected, actual);
	}
	
	@Test
	void testNullTile() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
		
		Float expected = null;
		Float actual = manager.findOneFilmReplacementCostByFilmTitle(null);
		assertEquals(expected, actual);
	}

}
