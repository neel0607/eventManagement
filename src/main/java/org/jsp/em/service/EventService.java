package org.jsp.em.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jsp.em.dao.EventDao;
import org.jsp.em.entity.Event;
import org.jsp.em.exceptionClasses.NoEventFoundException;
import org.jsp.em.responseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
	@Autowired
	EventDao dao;

	public ResponseStructure<Event> saveEvent(Event event) {
		Event savedEvent = dao.saveEvent(event);
		
		ResponseStructure<Event> rs = new ResponseStructure<>();
		rs.setStatus(200);
		rs.setMessage("Event saved successfully.");
		rs.setBody(savedEvent);
		return rs;
	}

	public ResponseStructure<List<Event>> findAll() {
		List<Event> events = dao.findAll();
		ResponseStructure<List<Event>> rs = new ResponseStructure<>();
		
		if(events.isEmpty()) {
//			throw new RuntimeException("No Event present in database table.");
			throw new NoEventFoundException("No Event present in database table.");
		}
		rs.setStatus(200);
		rs.setMessage("Event found successfully.");
		rs.setBody(events);
		return rs;
	}

	public ResponseStructure<Event> findById(int id) {
		Optional<Event> optional = dao.findById(id);
		
		ResponseStructure<Event> rs = new ResponseStructure<>();
		
		if(optional.isPresent()) {
			Event event = optional.get();
			rs.setStatus(200);
			rs.setMessage("Event Found Successfully.");
			rs.setBody(event);
			
			return rs;
		}
		else {
			throw new NoEventFoundException("No Event present in database table.");
		}
	}

	public ResponseStructure<Event> deleteById(int id) {
		Optional<Event> optional = dao.findById(id);
		
		ResponseStructure<Event> rs = new ResponseStructure<>();
		
		if(optional.isPresent()) {
			Event event = optional.get();
			dao.deleteById(id);
			rs.setStatus(200);
			rs.setMessage("Event Deleted Successfully.");
			rs.setBody(event);
			
			return rs;
		}
		else {
			throw new NoEventFoundException("No Event present in database table.");
		}
	}

	public ResponseStructure<List<Event>> findByLetters(String letters) {
		List<Event> events = dao.findByLetters("%" + letters + "%");
		ResponseStructure<List<Event>> rs = new ResponseStructure<>();

		if(events.isEmpty()) {
			throw new NoEventFoundException("No Event present in database table.");
		}
		rs.setStatus(200);
		rs.setMessage("Event found successfully.");
		rs.setBody(events);
		return rs;
	}

	public ResponseStructure<List<Event>> findByGuestLetters(String letters) {
		List<Event> events = dao.findByGuestLetters("%" + letters + "%");
		ResponseStructure<List<Event>> rs = new ResponseStructure<>();

		if(events.isEmpty()) {
			throw new NoEventFoundException("No Event present in database table.");
		}
		rs.setStatus(200);
		rs.setMessage("Event found successfully.");
		rs.setBody(events);
		return rs;
	}

	public ResponseStructure<List<Event>> findByLocation(String letters) {
		List<Event> events = dao.findByLocation("%" + letters + "%");
		ResponseStructure<List<Event>> rs = new ResponseStructure<>();

		if(events.isEmpty()) {
			throw new NoEventFoundException("No Event present in database table.");
		}
		rs.setStatus(200);
		rs.setMessage("Event found successfully.");
		rs.setBody(events);
		return rs;
	}

	public ResponseStructure<List<Event>> findByDate(LocalDate date) {
		List<Event> events = dao.findByDate("%" + date + "%");
		
		ResponseStructure<List<Event>> rs = new ResponseStructure<>();
		if(events.isEmpty()) {
			throw new NoEventFoundException("No Event present in database table");
		}
		rs.setStatus(200);
		rs.setMessage("Event found successfully, filered by date.");
		rs.setBody(events);
		return rs;
	}
	
	
}
