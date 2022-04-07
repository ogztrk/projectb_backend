package com.badibul.backend.controller;

import com.badibul.backend.entity.Comment;
import com.badibul.backend.request.CommentCreateRequest;
import com.badibul.backend.request.CommentUpdateRequest;
import com.badibul.backend.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){
        return commentService.getOneCommentById(commentId);
    }
    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, Optional<Long> eventId){
        return commentService.getCommentByUserIdOrEventId(userId,eventId);

    }
    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId){

        commentService.deleteOneCommentById(commentId);

    }
    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest commentCreateRequest){

    return  commentService.createOneComment(commentCreateRequest);
    }
    @PutMapping("/{commentId}")

    public Comment updateOneComment(@PathVariable Long commentId,@RequestBody CommentUpdateRequest commentUpdateRequest){

        return commentService.updateOneComment(commentId,commentUpdateRequest);
    }

}
