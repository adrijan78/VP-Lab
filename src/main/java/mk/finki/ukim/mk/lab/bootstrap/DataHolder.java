package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.enums.Role;
import mk.finki.ukim.mk.lab.repository.EventRepository;
import mk.finki.ukim.mk.lab.repository.LocationRepository;
import mk.finki.ukim.mk.lab.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

	private final EventRepository eventRepository;
	private final UserRepository userRepository;

	private final LocationRepository locationRepository;
	private final PasswordEncoder passwordEncoder;

	public DataHolder(EventRepository eventRepository, UserRepository userRepository, LocationRepository locationRepository, PasswordEncoder passwordEncoder) {
		this.eventRepository = eventRepository;
		this.userRepository = userRepository;
		this.locationRepository = locationRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static List<Location> locations = null;
	public static List<Event> events = null;
	public static List<User> users = null;

	@PostConstruct
	public void init(){
		locations = new ArrayList<>();
		if (this.locationRepository.count() == 0) {
			locations.add(new Location((long) 1, "Kavadarci", "loc stree 123", "100", "first location"));
			locations.add(new Location((long) 2, "Skopje", "loc stree 124", "200", "second location"));
			locations.add(new Location((long) 3, "Veles", "loc stree 125", "300", "third location"));
			locations.add(new Location((long) 4, "Ohrid", "loc stree 126", "400", "fourth location"));
			locations.add(new Location((long) 5, "Strumica", "loc stree 127", "500", "fifth location"));

			locationRepository.saveAll(locations);

		}


		this.events = new ArrayList<>();
		if (this.eventRepository.count() == 0) {
			this.events.add(new Event("Event 1", "decription 1", 1.0, locations.get(0)));
			this.events.add(new Event("Event 2", "decription 2", 2.0, locations.get(0)));
			this.events.add(new Event("Event 3", "decription 3", 3.0, locations.get(1)));
			this.events.add(new Event("Event 4", "decription 4", 4.0, locations.get(1)));
			this.events.add(new Event("Event 5", "decription 5", 5.0, locations.get(2)));
			this.events.add(new Event("Event 6", "decription 6", 6.0, locations.get(2)));
			this.events.add(new Event("Event 7", "decription 7", 7.0, locations.get(3)));
			this.events.add(new Event("Event 8", "decription 8", 8.0, locations.get(3)));
			this.events.add(new Event("Event 9", "decription 9", 9.0, locations.get(4)));
			this.events.add(new Event("Event 10", "decription 10", 10.0, locations.get(4)));

			eventRepository.saveAll(events);
		}

		users = new ArrayList<>();
		if (this.userRepository.count() == 0) {
			users.add(new User("elena.atanasoska", passwordEncoder.encode("ea"), "Elena", "Atanasoska", Role.ROLE_USER));
			users.add(new User("darko.sasanski", passwordEncoder.encode("ds"), "Darko", "Sasanski", Role.ROLE_USER));
			users.add(new User("ana.todorovska", passwordEncoder.encode("at"), "Ana", "Todorovska", Role.ROLE_USER));
			users.add(new User("admin", passwordEncoder.encode("admin"), "admin", "admin", Role.ROLE_ADMIN));
			this.userRepository.saveAll(users);
		}

	}
}
