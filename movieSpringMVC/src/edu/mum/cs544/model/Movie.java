package edu.mum.cs544.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Movie {
	@Id @GeneratedValue
	private long movieId;
	private String title;
	@Lob
	private byte[] poster;
	private String summary;
	private int year;
	
	@ManyToMany
	@JoinTable(name="Movie_Artist", joinColumns=@JoinColumn(name="movieId"), inverseJoinColumns=@JoinColumn(name="artistId"))
	private List<Artist> artists;
	
	@OneToMany
	@JoinColumn(name="movieId")
	private List<MovieReview> reviews;
	
	@Enumerated(EnumType.STRING)
	private MovieRating rated;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;

	public List<MovieReview> getReviews() {
		return reviews;
	}
//	public void setReviews(List<MovieReview> reviews) {
//		this.reviews = reviews;
//	}
	public void addReview(MovieReview review){
		if(reviews==null){
			reviews = new ArrayList<MovieReview>();
		}
		reviews.add(review);
		
	}
	public MovieRating getRated() {
		return rated;
	}
	public void setRated(MovieRating rated) {
		this.rated = rated;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public byte[] getPoster() {
		return poster;
	}
	public void setPoster(byte[] poster) {
		this.poster = poster;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Artist> getArtists() {
		return artists;
	}
//	public void setArtists(List<Artist> artists) {
//		this.artists = artists;
//	}
	public void addArtist(Artist artist){
		if(artists==null){
			artists = new ArrayList<Artist>();
			artists.add(artist);
			return;
		}
		artists.add(artist);
	}
}
