package be.afelio.software_academy.pco.jdbc.example;

import be.afelio.software_academy.pco.jdbc.example.beans.Film;

public interface DvdRentalJdbcExampleRepository {

	boolean ping();
	String findOneActorFirstNameByActorName(String name);
	Float findOneFilmReplacementCostByFilmTitle(String title);
	java.util.List<String> findAllCityNamesByCountryNameOrderByCityName(String countryName);
	java.util.List<Film> findAllFilmsByLanguageName(String language);
	boolean updateFilmReplacementCostByFilmTitle(String title, float newReplacementCost);
	
}
