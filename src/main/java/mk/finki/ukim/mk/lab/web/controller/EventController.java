package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import mk.finki.ukim.mk.lab.service.impl.EventServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {

	private final EventService eventService;
	private final LocationService locationService;

	public EventController(EventServiceImpl eventService, LocationService locationService){
		this.eventService = eventService;
		this.locationService = locationService;
	}
	@GetMapping
	public String getEventsPage(@RequestParam(required = false) String error, Model model){
		model.addAttribute("events",eventService.listAll());
		if (error != null) {
			model.addAttribute("error", error);
		}
		return "listEvents.html";
	}
	@GetMapping("/add-form")
	public String getAddEventPage(@RequestParam(required = false) String error, Model model){
		model.addAttribute("locations",locationService.findAll());
		return "add-Event.html";
	}
	@PostMapping("/add")
	public String saveEvent(@RequestParam String name, @RequestParam String description,@RequestParam String score,@RequestParam String location){
		eventService.save(name,description,Double.parseDouble(score),locationService.findAll().get(0));
		return "redirect:/events";
	}

	@GetMapping("/view/{id}")
	public String getDetailsEventPage(@PathVariable Long id,@RequestParam(required = false) String error, Model model){
		model.addAttribute("locations",locationService.findAll());
		if(eventService.getEventById(id) == null){
			return "redirect:/events?error=Event not found";
		}
		Event event = eventService.getEventById(id);
		model.addAttribute("event",event);
		return "view-event.html";
	}

	@GetMapping("/edit-form/{id}")
	public String getEditEventForm(@PathVariable Long id,@RequestParam(required = false) String error, Model model){
		model.addAttribute("locations",locationService.findAll());
		if(eventService.getEventById(id) == null){
			return "redirect:/events?error=Event not found";
		}
		Event event = eventService.getEventById(id);
		model.addAttribute("event",event);
		return "add-Event.html";
	}
	@PostMapping("/edit/{eventId}")
	public String editEvent(@PathVariable Long eventId,@RequestParam String name, @RequestParam String description,@RequestParam String score,@RequestParam String location){
		Location loc = locationService.findById(Long.parseLong(location));
		double popularityScore = Double.parseDouble(score);
		eventService.update(eventId,name,description,popularityScore,loc);
		return "redirect:/events";
	}
	@PostMapping("/delete/{id}")
	public String deleteEvent(@PathVariable Long id){
		eventService.delete(id);
		return "redirect:/events";
	}
}
