package be.afelio.software_academy.pco.jdbc.example.beans;

import java.util.Objects;

public class Film {
	
	private String title;
	private String description;
	private Integer year;
	private Integer length;
	private String language;

	public Film() {}

	public Film(String title, String description, Integer year, Integer length, String language) {
		this.title = title;
		this.description = description;
		this.year = year;
		this.length = length;
		this.language = language;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Film film = (Film) o;
		return Objects.equals(title, film.title) &&
				Objects.equals(description, film.description) &&
				Objects.equals(year, film.year) &&
				Objects.equals(length, film.length) &&
				Objects.equals(language, film.language);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, description, year, length, language);
	}
}
