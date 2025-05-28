package org.jsp.em.controller;

import java.time.LocalDate;
import java.util.List;

import org.jsp.em.entity.Event;
import org.jsp.em.responseStructure.ResponseStructure;
import org.jsp.em.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
	@Autowired
	EventService service;
	
	@PostMapping
	public ResponseStructure<Event> saveEvent(@RequestBody Event event) {
		return service.saveEvent(event);
	}
	
	@GetMapping
	public ResponseStructure<List<Event>> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseStructure<Event> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseStructure<Event> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	@GetMapping("/title/{letters}")
	public ResponseStructure<List<Event>> findByLetters(@PathVariable String letters) {
		return service.findByLetters(letters);
	}
	
	@GetMapping("/guest/{letters}")
	public ResponseStructure<List<Event>> findByGuestLetters(@PathVariable String letters) {
		return service.findByGuestLetters(letters);
	}
	
	@GetMapping("/guest/{letters}")
	public ResponseStructure<List<Event>> findByLocation(@PathVariable String letters) {
		return service.findByLocation(letters);
	}
	
	@GetMapping("/date/{date}")
	public ResponseStructure<List<Event>> findByDate(@PathVariable LocalDate date) {
		return service.findByDate(date);
	}
}
