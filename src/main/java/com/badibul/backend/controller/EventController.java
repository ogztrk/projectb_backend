package com.badibul.backend.controller;


import com.badibul.backend.entity.Events;

import com.badibul.backend.request.EventCreateRequest;
import com.badibul.backend.request.EventUpdateRequest;
import com.badibul.backend.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    private  final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{eventId}")
    public Events getEventById(@PathVariable Long eventId){

        return  eventService.GetOneEvent(eventId);
    }
    //user idye göre eventleri alma fonksiyonu.
    @GetMapping
    public List<Events> getAllEvents(@RequestParam Optional<Long> userId){

        return  eventService.getEventsByUserId(userId);
    }

    @PostMapping
    public Events createOneEvent(@RequestBody EventCreateRequest eventCreateRequest){


        return eventService.createNew(eventCreateRequest);
    }

    @PutMapping("/{eventId}")
    public Events updateOneEvent(@PathVariable Long eventId, @RequestBody EventUpdateRequest eventUpdateRequest ){

        return  eventService.updateEvent(eventId,eventUpdateRequest);

    }

    @DeleteMapping("/{eventId}")
    public void DeleteOneEvent(@PathVariable Long eventId){

        eventService.DeleteEventById(eventId);
    }


}
