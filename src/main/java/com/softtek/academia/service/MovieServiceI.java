package com.softtek.academia.service;

import java.util.List;

import com.softtek.academia.entity.Movie;

public interface MovieServiceI {
	public List<Movie> getAllMovies();
	public Movie getMovieById(Integer id);
	public Movie saveMovie(Movie movie);
	public Movie updateMovie(Movie movie);
	public void deleteMovieById(Integer id);
	public Movie patchMovie(Integer id, Movie requestBody);
	public Movie getMovieByTitle(String title);
}