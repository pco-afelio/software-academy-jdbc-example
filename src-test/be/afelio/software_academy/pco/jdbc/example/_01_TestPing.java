package be.afelio.software_academy.pco.jdbc.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class _01_TestPing {

	@Test
	void test() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
		
		boolean pinged = manager.ping();
		assertTrue(pinged);
	}

}
