package com.softtek.academia.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academia.entity.Movie;
import com.softtek.academia.repository.jpa.MovieRepository;

@Service
public class MovieService implements MovieServiceI{
	@Autowired
	private MovieRepository movieRepository;

	
	public static final Logger LOOGER = LoggerFactory.getLogger(MovieService.class);

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = (List<Movie>) this.movieRepository.findAll();
		LOOGER.info("## Movie List Obtained: {}", movies);
		return movies;
	}

	@Override
	public Movie getMovieById(Integer id) {
		Movie movie = this.movieRepository.findById(id).orElse(null);
		LOOGER.info("## Movie List Obtained: {}", movie);
		return movie;
	}

	@Override
	public Movie saveMovie(Movie movie) {
		return this.movieRepository.save(movie);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		return this.movieRepository.save(movie);
	}

	@Override
	public void deleteMovieById(Integer id) {
		this.movieRepository.deleteById(id);	
	}

	@Override
	public Movie patchMovie(Integer id, Movie requestBody) {
		Movie movie = this.getMovieById(id);
		movie.setId(id);
		movie.setTitle(requestBody.getTitle() !=null ? requestBody.getTitle() : movie.getTitle());
		movie.setYear(requestBody.getYear() !=null ? requestBody.getYear() : movie.getYear());
		movie.setRating(requestBody.getRating() !=null ? requestBody.getRating() : movie.getRating());
		movie.setDirector_id(requestBody.getDirector_id() !=null ? requestBody.getDirector_id() : movie.getDirector_id());
		movie.setGenre_id(requestBody.getGenre_id() !=null ? requestBody.getGenre_id() : movie.getGenre_id());	
		return this.movieRepository.save(movie);
	}

	@Override
	public Movie getMovieByTitle(String title) {
		for(Movie movie : this.movieRepository.findAll())
			if(movie.getTitle().equals(title))
				return movie;
		return null;
	}
}
