package org.jsp.em.repository;

import java.util.List;

import org.jsp.em.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Integer>{
	
	@Query("select e from Event e where e.title like ?1")
	List<Event> findByLetters(String letters);
	
	@Query("select e from Event e where e.guest like ?1")
	List<Event> findByGuestLetters(String letters);
	
	@Query("select e from Event e where e.location like ?1")
	List<Event> findByLocation(String letters);
	
	@Query("select e from Event e where e.date like ?1")
	List<Event> findByDate(String date);
	
}
