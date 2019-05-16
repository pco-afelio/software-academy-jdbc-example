package be.afelio.software_academy.pco.jdbc.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import be.afelio.software_academy.pco.jdbc.example.beans.Film;

class _05_TestFindAllFilmsByLanguageName {

	@Test
	void testExistingLanguage() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);
		
		Film expected = new Film(
				"Chamber Italian", 
				"A Fateful Reflection of a Moose And a Husband who must Overcome a Monkey in Nigeria", 
				2006, 117, "English");
		List<Film> actual = manager.findAllFilmsByLanguageName("English");
		
		assertNotNull(actual);
		assertEquals(1000, actual.size());
		assertTrue(actual.contains(expected));
	}
	
	@Test
	void testNonExistingLanguage() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);

		List<Film> actual = manager.findAllFilmsByLanguageName("French");
		
		assertNotNull(actual);
		assertEquals(0, actual.size());
	}

	@Test
	void testNullLanguage() {
		DvdRentalJdbcExampleRepository manager = Factory.createDvdRentalJdbcExampleRepository();
		assertNotNull(manager);

		List<Film> actual = manager.findAllFilmsByLanguageName(null);
		
		assertNotNull(actual);
		assertEquals(0, actual.size());
	}
}
