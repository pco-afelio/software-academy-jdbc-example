package be.afelio.software_academy.pco.jdbc.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _00_TestFactory {

	@Test
	void test() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
	}

}
