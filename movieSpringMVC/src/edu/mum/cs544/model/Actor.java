package edu.mum.cs544.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("actor")
public class Actor extends Artist{

	private String role;
	private boolean isLeadCharacter;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isLeadCharacter() {
		return isLeadCharacter;
	}
	public void setLeadCharacter(boolean isLeadCharacter) {
		this.isLeadCharacter = isLeadCharacter;
	}
	
}
