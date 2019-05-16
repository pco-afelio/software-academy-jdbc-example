package be.afelio.software_academy.pco.jdbc.example;

public class Factory {

	public static DvdRentalJdbcExampleRepository createDvdRentalJdbcExampleRepository() {
		return new DvdRentalJdbcExampleRepositoryImpl(
				"postgres", 
				"postgres", 
				"jdbc:postgresql://192.168.2.57:5432/dvdrental");
	}
}
