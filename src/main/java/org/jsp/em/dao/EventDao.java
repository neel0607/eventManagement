package org.jsp.em.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.em.entity.Event;
import org.jsp.em.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventDao {
	@Autowired
	EventRepository er;

	public Event saveEvent(Event event) {
		return er.save(event);
	}

	public List<Event> findAll() {
		return er.findAll();
	}

	public Optional<Event> findById(int id) {
		return er.findById(id);
	}

	public void deleteById(int id) {
		er.deleteById(id);
	}

	public List<Event> findByLetters(String letters) {
		return er.findByLetters(letters);
	}

	public List<Event> findByGuestLetters(String letters) {
		return er.findByGuestLetters(letters);
	}

	public List<Event> findByLocation(String letters) {
		return er.findByLocation(letters);
	}

	public List<Event> findByDate(String date) {
		return er.findByDate(date);
	}

}
