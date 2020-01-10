package com.softtek.academia.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="genre_id")
	private Genre genre_id;
	
	private Integer year;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="director_id")
	private Director director_id;
	
	private Integer rating;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Genre getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(Genre genre_id) {
		this.genre_id = genre_id;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Director getDirector_id() {
		return director_id;
	}
	public void setDirector_id(Director director_id) {
		this.director_id = director_id;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
}
