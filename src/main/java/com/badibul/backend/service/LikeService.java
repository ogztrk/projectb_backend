package com.badibul.backend.service;

import com.badibul.backend.entity.Like;
import com.badibul.backend.repository.LikeRepository;
import com.badibul.backend.request.LikeCreateRequest;
import com.badibul.backend.response.LikeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


    public List<LikeResponse> getLikeByUserOrEventId(Optional<Long> userId, Optional<Long> eventId) {
        List<Like> list;
        if(userId.isPresent()&& eventId.isPresent()){
            list= likeRepository.findByUserIdAndEventId(userId.get(),eventId.get());
        }
        else if(userId.isPresent()){
            list=  likeRepository.findByUserId(eventId.get());
        }
        else if(eventId.isPresent()){
            list=  likeRepository.findByEventId(eventId.get());
        }
        else{
            list=likeRepository.findAll();
        }
        return  list.stream().map(p-> new LikeResponse(p)).collect(Collectors.toList());
    }

    public Like getLikeById(Long likeId) {
        return likeRepository.findById(likeId).orElseThrow(null);
    }

    public Like createOneLike(LikeCreateRequest likeCreateRequest) {
        if (userService.getOneUser(likeCreateRequest.getUserId())!=null&& eventService.GetOneEvent(likeCreateRequest.getEventId())!=null){
            Like newlike= new Like();
            newlike.setUser(userService.getOneUser(likeCreateRequest.getUserId()));
            newlike.setEvent(eventService.GetOneEvent(likeCreateRequest.getEventId()));
            likeRepository.save(newlike);
            return newlike;
        }
        return  null;
    }

    public void deleteLikeById(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
