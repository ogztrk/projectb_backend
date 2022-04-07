package com.badibul.backend.service;

import com.badibul.backend.entity.Like;
import com.badibul.backend.repository.LikeRepository;
import com.badibul.backend.request.LikeCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    private  final LikeRepository likeRepository;
    private  final UserService userService;
    private  final  EventService eventService;

    public LikeService(LikeRepository likeRepository, UserService userService, EventService eventService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.eventService = eventService;
    }


    public List<Like> getLikeByUserOrEventId(Optional<Long> userId, Optional<Long> eventId) {
        if(userId.isPresent()&& eventId.isPresent()){
            return likeRepository.findByUserIdAndEventId(userId.get(),eventId.get());
        }
        else if(userId.isPresent()){
            return  likeRepository.findByUserId(eventId.get());
        }
        else if(eventId.isPresent()){
            return  likeRepository.findByEventId(eventId.get());
        }
        return  likeRepository.findAll();
    }

    public Like getLikeById(Long likeId) {
        return likeRepository.findById(likeId).orElseThrow(null);
    }

    public Like createOneLike(LikeCreateRequest likeCreateRequest) {
        if (userService.getOneUser(likeCreateRequest.getUserId())!=null&& eventService.GetOneEvent(likeCreateRequest.getEventId())!=null){
            Like newlike= new Like();
            newlike.setId(likeCreateRequest.getId());
            newlike.setUser(userService.getOneUser(likeCreateRequest.getUserId()));
            newlike.setEvent(eventService.GetOneEvent(likeCreateRequest.getEventId()));
            return likeRepository.save(newlike);

        }
        return  null;
    }

    public void deleteLikeById(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
