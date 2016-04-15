package edu.mum.cs544.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "artist_type", discriminatorType=DiscriminatorType.STRING)
public abstract class Artist {
	@Id @GeneratedValue
	private long artistId;
	private String name;
	@Lob
	private byte[] profilePicture;
	private String biography;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private BirthInfo birthInfo;
	
	@ManyToMany(mappedBy="artists")
	private Collection<Movie> movies;
	
	
	public byte[] getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
		
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public BirthInfo getBirthInfo() {
		return birthInfo;
	}
	public void setBirthInfo(BirthInfo birthInfo) {
		this.birthInfo = birthInfo;
	}
	public Collection<Movie> getMovies() {
		return movies;
	}
//	public void setMovies(Collection<Movie> movies) {
//		this.movies = movies;
//	}
	public void addMovie(Movie movie){
		if(movies==null){
			movies = new ArrayList<Movie>();
			movies.add(movie);
			return;
		}
		movies.add(movie);
	}
	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}
	public long getArtistId() {
		return artistId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
