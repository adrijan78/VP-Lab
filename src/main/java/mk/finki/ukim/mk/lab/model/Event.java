package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
public class Event {

	public Event(){

	}
	public Event(String name,String description,double popularityScore,Location location){
		this.name = name;
		this.description = description;
		this.popularityScore = popularityScore;
		this.location = location;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPopularityScore(double popularityScore) {
		this.popularityScore = popularityScore;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPopularityScore() {
		return popularityScore;
	}

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private double popularityScore;
	@ManyToOne
	private Location location;
}
