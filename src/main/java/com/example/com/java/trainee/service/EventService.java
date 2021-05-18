package com.example.com.java.trainee.service;

import com.example.com.java.trainee.entity.Event;
import com.example.com.java.trainee.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Transactional(readOnly = true)
    public Iterable<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public void addEvent(Event event){
        eventRepository.save(event);
    }

    public Event getEvent(long id){
        return eventRepository.findById(id).get();
    }

    public void deleteEvent(long id){
        eventRepository.deleteById(id);
    }

    public void updateEvent(Event event,long id){
        Event eventToUpdate=getEvent(id);
        eventToUpdate.setName(event.getName());
        eventToUpdate.setDate(event.getDate());

        eventRepository.save(eventToUpdate);
    }
}
