package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
public class Location {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String address;
	private String capacity;
	private String description;
	@OneToMany(mappedBy = "location")
	private List<Event> events;

	public Location() {
	}

	public Location(Long id, String name, String address, String capacity, String description) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.capacity = capacity;
		this.description = description;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
