package edu.mum.cs544.DAO;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.model.Movie;
import edu.mum.cs544.repository.MovieRepository;

@Component
@Transactional(readOnly = true)
public class MovieDAOImp implements IMovieDAO {
	
//	private EntityManager currentSession;
//	private EntityTransaction currentTransaction;
	
	//private SessionFactory sf;
	
	@Inject
	private MovieRepository repository;
	
	public MovieDAOImp(){}
	
//	public EntityManager openCurrentSession() {
//		currentSession = getEntityManagerFactory().createEntityManager();//getSessionFactory().openSession();
//		return currentSession;
//	}
//
//	public EntityManager openCurrentSessionwithTransaction() {
//		currentSession = getEntityManagerFactory().createEntityManager();
//		currentTransaction = currentSession.getTransaction();
//		return currentSession;
//	}
//	
//	public void closeCurrentSession() {
//		currentSession.close();
//	}
//			     
//	public void closeCurrentSessionwithTransaction() {
//		currentTransaction.commit();
//		currentSession.close();
//	}
//	
//	private static EntityManagerFactory getEntityManagerFactory() {
//		EntityManagerFactory emf;
//		try {
//			emf = Persistence.createEntityManagerFactory("cs544");
//		} catch (Throwable ex) {
//			ex.printStackTrace();
//			throw new ExceptionInInitializerError(ex);
//		}
//		return emf;
//	}
//			 
//	public EntityManager getCurrentSession() {
//		return currentSession;
//	}
//	
//	public void setCurrentSession(EntityManager currentSession) {
//		this.currentSession = currentSession;
//	}
//	
//	public EntityTransaction getCurrentTransaction() {
//		return currentTransaction;
//	}
//
//	public void setCurrentTransaction(EntityTransaction currentTransaction) {
//		this.currentTransaction = currentTransaction;
//	}

//	public SessionFactory getSf() {
//		return sf;
//	}
//
//	public void setSf(SessionFactory sf) {
//		this.sf = sf;
//	}
	
	@Transactional
	public void create(Movie movie) {
		//sf.getCurrentSession().persist(movie);
		repository.save(movie);
	}

	@Transactional
	public void update(Movie movie) {
		//sf.getCurrentSession().merge(movie);
		repository.save(movie);
	}

	@Transactional
	public Movie findById(long l) {
		//Movie movie = (Movie) sf.getCurrentSession().get(Movie.class, l);
       // return movie; 
		return repository.findOne(l);
	}

	@Transactional
	public void delete(Movie movie) {
		//sf.getCurrentSession().delete(movie);
		repository.delete(movie);
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	@SuppressWarnings("unchecked")
	public List<Movie> findAll() {
		//List<Movie> movies = (List<Movie>) sf.getCurrentSession().createQuery("from Movie").list();
        //return movies;
		return (List<Movie>) repository.findAll();
	}

	public void deleteAll() {
//		List<Movie> movieList = findAll();
//			for (Movie movie : movieList) {
//			delete(movie);
//        }
		repository.deleteAll();
	}

	@Override
	public List<Movie> findByTitle(String titel) {
		
		return repository.findByTitle(titel);
	}

}
