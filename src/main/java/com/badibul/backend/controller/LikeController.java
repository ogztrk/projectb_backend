package com.badibul.backend.controller;


import com.badibul.backend.entity.Like;
import com.badibul.backend.request.LikeCreateRequest;
import com.badibul.backend.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController{

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }
    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Long> userId, @RequestParam Optional <Long> eventId){

        return  likeService.getLikeByUserOrPostId(userId,eventId);
    }

    @GetMapping("/{likeId}")
    public  Like getLikeById(@PathVariable Long likeId){

        return  likeService.getLikeById(likeId);
    }
    @PostMapping
    public  Like createOneLike(@RequestBody LikeCreateRequest likeCreateRequest){
        return  likeService.createOneLike(likeCreateRequest);

    }
    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId){
        likeService.deleteLikeById(likeId);
    }



}



