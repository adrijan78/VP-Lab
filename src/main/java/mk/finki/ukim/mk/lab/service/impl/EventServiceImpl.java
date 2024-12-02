package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.EventRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public Optional<Event> delete(long id) {
		Optional<Event> ret = eventRepository.findById(id);
		eventRepository.deleteById(id);
		return ret;
	}

	public EventServiceImpl() {
	}

	@Override
	public List<Event> listAll() {
		return eventRepository.findAll();
	}

	@Override
	public List<Event> searchByName(String text) {
		return eventRepository.findByNameIgnoreCase(text);
	}

	@Override
	public List<Event> searchByScore(double score) {
		return eventRepository.findByPopularityScoreGreaterThanEqual(score);
	}

	@Override
	public Optional<Event> save(String name, String description, double score, Location location) {
		Event newEvent = new Event(name,description,score,location);
		return Optional.of(this.eventRepository.save(newEvent));
	}

	@Override
	public Event getEventById(long id) {
		return this.eventRepository.findById(id).get();
	}

	@Override
	public Optional<Event> update(long id, String name, String description, double score, Location location) {
		Event event = eventRepository.findById(id).get();
		event.setName(name);
		event.setDescription(description);
		event.setPopularityScore(score);
		event.setLocation(location);
		return Optional.of(eventRepository.save(event));
	}

	@Override
	public List<Event> searchByNameAndScore(String text, double score) {
		return eventRepository.findByNameIgnoreCaseAndPopularityScoreGreaterThanEqual(text, score);
	}

}

