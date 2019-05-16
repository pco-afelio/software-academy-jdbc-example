package be.afelio.software_academy.pco.jdbc.example;

import java.util.List;

import be.afelio.software_academy.pco.jdbc.example.beans.Film;

public class DvdRentalJdbcExampleRepositoryImpl implements DvdRentalJdbcExampleRepository {

	protected String user;
	protected String password;
	protected String url;
	
	public DvdRentalJdbcExampleRepositoryImpl(String user, String password, String url) {
		super();
		this.user = user;
		this.password = password;
		this.url = url;
	}

	@Override
	public boolean ping() /*throws java.sql.SQLException*/ {
		boolean pinged = false;
		
		try {
			java.sql.Connection connection
				= java.sql.DriverManager.getConnection(url, user, password);
			pinged = true;
		} catch(java.sql.SQLException sqle) {
			throw new RuntimeException(sqle);
		}
		
		return pinged;
	}

	@Override
	public String findOneActorFirstNameByActorName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float findOneFilmReplacementCostByFilmTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findAllCityNamesByCountryNameOrderByCityName(String countryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> findAllFilmsByLanguageName(String language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateFilmReplacementCostByFilmTitle(String title, float newReplacementCost) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
