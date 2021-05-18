package com.example.com.java.trainee.rest;

import com.example.com.java.trainee.entity.Event;
import com.example.com.java.trainee.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class EventController {

    @Autowired
    EventService eventService;

    @RequestMapping("/")
    public String sayHello(){

        return "hallo s ommi";


    }

    @PostMapping("/events/api/events/")
    public void addEvent(@RequestBody Event event1){
        eventService.addEvent(event1);
    }
    // get all event
    @GetMapping("api/events/")
    public Iterable<Event> getAllEvents(){
        return  eventService.getAllEvents();
    }

    // get event by id
    @GetMapping("api/events/{id}")
    public Event getEventById(@PathVariable long id){
        return  eventService.getEvent(id);
    }

    // update event by id
    @PutMapping("api/events/{id}")
    public void updateEvent(@RequestBody Event event, @PathVariable long id){
        eventService.updateEvent(event,id);
    }

    @DeleteMapping("api/events/{id}")
    public void deleteEvent(@PathVariable long id){
        eventService.deleteEvent(id);
    }


}
