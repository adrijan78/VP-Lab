package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;

import java.util.List;
import java.util.Optional;

public interface EventService {
	List<Event> listAll();
	List<Event> searchByName(String text);
	List<Event> searchByScore(double score);
	List<Event> searchByNameAndScore(String text,double score);
	Event getEventById(long id);
	Optional<Event> save(String name, String description, double score, Location location);
	Optional<Event> update(long id,String name, String description, double score, Location location);
	Optional<Event> delete(long id);
}