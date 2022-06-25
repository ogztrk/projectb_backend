package com.badibul.backend.service;

import com.badibul.backend.entity.Events;
import com.badibul.backend.repository.EventsRepository;
import com.badibul.backend.request.EventCreateRequest;
import com.badibul.backend.request.EventUpdateRequest;
import com.badibul.backend.response.EventResponse;
import com.badibul.backend.response.LikeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventsRepository eventsRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private LikeService likeService;

    public EventService(EventsRepository eventsRepository, UserService userService, CategoryService categoryService) {
        this.eventsRepository = eventsRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Autowired
    public void setLikeService(@Lazy LikeService likeService) {
        this.likeService = likeService;
    }
    public Events GetOneEvent(Long eventId){
        return eventsRepository.findById(eventId).orElseThrow(null);
    }


    public List<EventResponse> getEventsByUserIdOrCategoryIdWithLikes(Optional<Long> userId, Optional<Long> categoryId) {
            List<Events> list;
        if (userId.isPresent() && categoryId.isPresent()) {
            list= eventsRepository.findByUserIdAndCategoryId(userId.get(), categoryId.get());}
        else if(userId.isPresent()){
            list= eventsRepository.findByUserId(userId.get());
        }
        else if(categoryId.isPresent()){
            list= eventsRepository.findByCategoryId(categoryId.get());
        }
        else{
            list=eventsRepository.findAll();
        }
        return  list.stream().map(p->{

            List<LikeResponse> likes = likeService.getLikeByUserOrEventId(Optional.ofNullable(null), Optional.of(p.getId()));
            return new EventResponse(p, likes);}).collect(Collectors.toList());

    };


    public EventResponse getOnePostByIdWithLikes(Long eventId) {
        Events event = eventsRepository.findById(eventId).orElse(null);
        List<LikeResponse> likes = likeService.getLikeByUserOrEventId(Optional.ofNullable(null), Optional.of(eventId));
        return new EventResponse(event, likes);
    }

    public Events createNew(EventCreateRequest eventCreateRequest) {
        if (userService.getOneUser(eventCreateRequest.getUserId())!=null){
            Events newEvent= new Events();
            newEvent.setActive(true);
            newEvent.setUser(userService.getOneUser(eventCreateRequest.getUserId()));
            newEvent.setBitisTarihi(eventCreateRequest.getBitisTarihi());
            newEvent.setCategory(categoryService.getOneCategory(eventCreateRequest.getCategoryId()));
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
