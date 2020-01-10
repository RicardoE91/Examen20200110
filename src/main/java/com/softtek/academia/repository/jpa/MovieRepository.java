package com.softtek.academia.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.softtek.academia.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer>  {

}