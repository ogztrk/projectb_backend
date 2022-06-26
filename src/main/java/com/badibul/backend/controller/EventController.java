package com.badibul.backend.controller;


import com.badibul.backend.entity.Events;

import com.badibul.backend.request.EventCreateRequest;
import com.badibul.backend.request.EventUpdateRequest;
import com.badibul.backend.response.EventResponse;
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
    public EventResponse getEventById(@PathVariable Long eventId){

        return  eventService.getOneEventById(eventId);
    }
    //user idye göre eventleri alma fonksiyonu.
    // http://localhost:8080/events?userId=1 seklinde test ett.
    @GetMapping
    public List<EventResponse> getAllEvents(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> categoryId){

        return  eventService.getEventsByUserIdOrCategoryId(userId,categoryId);
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
