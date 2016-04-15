package edu.mum.cs544.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MovieReview {

	@Id @GeneratedValue
	private long reviewId;
	@Temporal(TemporalType.DATE)
	private Date date;
	private int rating;
	private String comment;
	private String criticName;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCriticName() {
		return criticName;
	}
	public void setCriticName(String criticName) {
		this.criticName = criticName;
	}
}
