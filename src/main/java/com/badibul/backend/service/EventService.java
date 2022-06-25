package com.badibul.backend.service;

import com.badibul.backend.entity.Events;
import com.badibul.backend.repository.EventsRepository;
import com.badibul.backend.request.EventCreateRequest;
import com.badibul.backend.request.EventUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventsRepository eventsRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public EventService(EventsRepository eventsRepository, UserService userService, CategoryService categoryService) {
        this.eventsRepository = eventsRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    public Events GetOneEvent(Long eventId){
        return eventsRepository.findById(eventId).orElseThrow(null);
    }


    public List<Events> getEventsByUserId(Optional<Long> userId) {

        if(userId.isPresent()){
            return eventsRepository.findByUserId(userId.get());
        }

        return  eventsRepository.findAll();
    }

    public Events createNew(EventCreateRequest eventCreateRequest) {
        if (userService.getOneUser(eventCreateRequest.getUserId())!=null){
            Events newEvent= new Events();
            newEvent.setActive(true);
            newEvent.setUser(userService.getOneUser(eventCreateRequest.getUserId()));
            newEvent.setBitisTarihi(null);
            newEvent.setCategories(categoryService.getCategories(eventCreateRequest.getCategory_id()));
            newEvent.setBaslangicTarihi(eventCreateRequest.getBaslangicTarihi());
            newEvent.setText(eventCreateRequest.getText());
            newEvent.setTitle(eventCreateRequest.getTitle());
            return  eventsRepository.save(newEvent);
        }
        return null;

    }

    public Events updateEvent(Long eventId, EventUpdateRequest eventUpdateRequest) {
        Optional<Events> event=eventsRepository.findById(eventId);
        if(event.isPresent()){
            Events updatedEvent=event.get();
            updatedEvent.setTitle(eventUpdateRequest.getTitle());
            updatedEvent.setText(eventUpdateRequest.getText());
            updatedEvent.setBaslangicTarihi(eventUpdateRequest.getBaslangicTarihi());
            updatedEvent.setBitisTarihi(eventUpdateRequest.getBitisTarihi());
            updatedEvent.setActive(eventUpdateRequest.isActive());
        return eventsRepository.save(updatedEvent);

        }
        return null;
    }


    public void DeleteEventById(Long eventId) {
        eventsRepository.deleteById(eventId);
    }
}
