package edu.mum.cs544.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("director")
public class Director extends Artist{

	private boolean isLeadDirector;

	public boolean isLeadDirector() {
		return isLeadDirector;
	}

	public void setLeadDirector(boolean isLeadDirector) {
		this.isLeadDirector = isLeadDirector;
	}
	
}
