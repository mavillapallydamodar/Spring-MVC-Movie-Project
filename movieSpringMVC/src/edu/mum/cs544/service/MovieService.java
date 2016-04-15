package edu.mum.cs544.service;

import java.util.List;

import edu.mum.cs544.DAO.IMovieDAO;
import edu.mum.cs544.model.Movie;

public class MovieService<T> {

	@SuppressWarnings("rawtypes")
	private IMovieDAO MovieDao;
	
	public MovieService(){}
	
	@SuppressWarnings("unchecked")
	public void save(Movie movie) {
		MovieDao.create(movie);
		
    }
	
	public void update(Movie movie) {
		MovieDao.update(movie);
		
    }
	
	public Movie findById(long l) {
		Movie movie = MovieDao.findById(l);
		return movie;
	}
	
	public void delete(long movieId) {
		Movie movie = MovieDao.findById(movieId);
		MovieDao.delete(movie);
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> findAll() {
		List<Movie> movies = MovieDao.findAll();
		return movies;
	}
			 
	public void deleteAll() {
		MovieDao.deleteAll();
	}
			 
	@SuppressWarnings("unchecked")
	public IMovieDAO movieDao() {
		return MovieDao;
	}

	public IMovieDAO getMovieDao() {
		return MovieDao;
	}

	public void setMovieDao(IMovieDAO movieDao) {
		MovieDao = movieDao;
	}
	
	
}
