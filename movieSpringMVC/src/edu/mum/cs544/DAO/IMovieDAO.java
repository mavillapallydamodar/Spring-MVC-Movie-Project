package edu.mum.cs544.DAO;

import java.util.List;

import edu.mum.cs544.model.Movie;

public interface IMovieDAO {

	public void create(Movie movie);
	public void update(Movie movie);
	public Movie findById(long movieId);
	public List<Movie> findByTitle(String titel);
	public void delete(Movie movie);
	public List<Movie> findAll();
	public void deleteAll();
	
}
