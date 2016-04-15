package edu.mum.cs544.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.model.Movie;

@Component
@Transactional(readOnly = true) 
public interface MovieRepository extends CrudRepository<Movie, Long>{
	
	List<Movie> findByTitle(String titel);
}
