package mk.finki.ukim.mk.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventBookingController {

	@PostMapping("/bookEvent")
	public String getEventsPage(@RequestParam String eventName, @RequestParam String numTickets, Model model){
		model.addAttribute("eventName",eventName);
		model.addAttribute("numTickets",numTickets);
		return "bookingConfirmation.html";
	}
}
