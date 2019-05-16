package be.afelio.software_academy.pco.jdbc.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _02_TestFindOneActorFirstnameByActorName {

	@Test
	void test() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
		
		String expected = "Elvis";
		String actual = manager.findOneActorFirstNameByActorName("Marx");
		assertEquals(expected, actual);
		
		expected = null;
		actual = manager.findOneActorFirstNameByActorName(null);
		assertEquals(expected, actual);
		
		expected = null;
		actual = manager.findOneActorFirstNameByActorName("");
		assertEquals(expected, actual);
	}

}
