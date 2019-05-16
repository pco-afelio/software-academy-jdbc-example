package be.afelio.software_academy.pco.jdbc.example;

import java.util.ArrayList;
import java.util.Collections;
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
			@SuppressWarnings("unused")
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
		String firstname = null;
		
		if (name != null && !name.isBlank()) {
			String sql = "SELECT * "
					   + " FROM actor WHERE last_name = '" + name + "'";
			
			java.sql.Connection connection = null;
			java.sql.Statement query = null;
			java.sql.ResultSet resultSet = null;
			
			try {
				connection = java.sql.DriverManager.getConnection(url, user, password);
				query = connection.createStatement();
				resultSet = query.executeQuery(sql);
				
				boolean onFirstLine = resultSet.next();
				if (onFirstLine) {
					firstname = resultSet.getString("first_name");
				}
				
			} catch(java.sql.SQLException sqle) {
				throw new RuntimeException(sqle);
			} finally {
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch(java.sql.SQLException ignored) {}
				}
				if (query != null) {
					try {
						query.close();
					} catch(java.sql.SQLException ignored) {}
				}
				if (connection != null) {
					try {
						connection.close();
					} catch(java.sql.SQLException ignored) {}
				}
			}
		}
		
		return firstname;
	}

	@Override
	public Float findOneFilmReplacementCostByFilmTitle(String title) {
		Float replacementCost = null;
		
		if (title != null && !title.isBlank()) {
			String sql = "SELECT replacement_cost FROM film WHERE title = ?";
			
			try (
				java.sql.Connection connection 
					= java.sql.DriverManager.getConnection(url, user, password);
				java.sql.PreparedStatement query = connection.prepareStatement(sql);
			) {
				query.setString(1, title);
				try (
					java.sql.ResultSet resultSet = query.executeQuery();	
				) {
					if (resultSet.next()) {
						replacementCost = resultSet.getFloat(1);
					}
				}
			} catch(java.sql.SQLException sqle) {
				throw new RuntimeException(sqle);
			}	
		}
		
		return replacementCost;
	}

	@Override
	public List<String> findAllCityNamesByCountryNameOrderByCityName(String countryName) {
		List<String> cities = null;
		
		if (countryName != null && !countryName.isBlank()) {
			String sql = "select ci.city as town " + 
					"from city as ci join country as co on ci.country_id = co.country_id " + 
					"where co.country = ? " + 
					"order by ci.city";
			
			try (
				java.sql.Connection connection 
					= java.sql.DriverManager.getConnection(url, user, password);
				java.sql.PreparedStatement query = connection.prepareStatement(sql);
			) {
				query.setString(1, countryName);
				try (
					java.sql.ResultSet resultSet = query.executeQuery();	
				) {
					cities = new ArrayList<>();
					while (resultSet.next()) {
						String name = resultSet.getString("town");
						cities.add(name);
					}
				}
			} catch(java.sql.SQLException sqle) {
				throw new RuntimeException(sqle);
			}	
		} else {
			cities = Collections.emptyList();
		}
		
		return cities;
	}

	@Override
	public List<Film> findAllFilmsByLanguageName(String language) {
		List<Film> films = null;
		
		if (language != null && !language.isBlank()) {
			String sql = "select f.title, f.description, f.release_year, f.length, l.name " + 
					"from film f join language l on f.language_id = l.language_id " + 
					"where l.name = ?";
			
			try (
				java.sql.Connection connection 
					= java.sql.DriverManager.getConnection(url, user, password);
				java.sql.PreparedStatement query = connection.prepareStatement(sql);
			) {
				query.setString(1, language);
				try (
					java.sql.ResultSet resultSet = query.executeQuery();	
				) {
					films = new ArrayList<>();
					while (resultSet.next()) {
						String title = resultSet.getString(1);
						
						String description = resultSet.getString(2);
						Integer year = resultSet.getInt(3);
						int length = resultSet.getInt(4);
						String languageName = resultSet.getString(5).trim();
						Film film = new Film(title, description, year, length, languageName);
						films.add(film);
					}
				}
			} catch(java.sql.SQLException sqle) {
				throw new RuntimeException(sqle);
			}
		} else {
			films = Collections.emptyList();
		}
		
		return films;
	}

	@Override
	public boolean updateFilmReplacementCostByFilmTitle(String title, float newReplacementCost) {
		boolean updated = false;
		
		if (title != null && !title.isBlank() && newReplacementCost >= 0) {
			String sql = "update film set replacement_cost = ? where title = ?";
			try (
				java.sql.Connection connection 
					= java.sql.DriverManager.getConnection(url, user, password);
				java.sql.PreparedStatement query = connection.prepareStatement(sql);
			) {
				// connection.setAutoCommit(true);
				
				connection.setAutoCommit(false);
				query.setFloat(1, newReplacementCost);
				query.setString(2, title);
				query.executeUpdate(); // insert/update/delete
				int updatedRows = query.getUpdateCount();
				connection.commit();
				
				updated = updatedRows > 0;
			} catch(java.sql.SQLException sqle) {
				throw new RuntimeException(sqle);
			}
		}
		
		return updated;
	}

	
}
