package com.example.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cinema.model.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

	List<MovieEntity> findMoviesByActor(String name);
	
}
