package com.badibul.backend.service;

import com.badibul.backend.entity.Comment;
import com.badibul.backend.repository.CommentRepository;
import com.badibul.backend.request.CommentCreateRequest;
import com.badibul.backend.request.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final EventService eventService;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, EventService eventService, UserService userService) {
        this.commentRepository = commentRepository;
        this.eventService = eventService;
        this.userService = userService;
    }


    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(null);
    }

    public List<Comment> getCommentByUserIdOrEventId(Optional<Long> userId, Optional<Long> eventId) {
        if (userId.isPresent() && eventId.isPresent()) {
            return commentRepository.findByUserIdAndEventId(userId.get(), eventId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (eventId.isPresent()) {
            return commentRepository.findByEventId(eventId.get());
        }
        return commentRepository.findAll();
    }

    public void deleteOneCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {
        if (userService.getOneUser(commentCreateRequest.getUserId()) != null && eventService.GetOneEvent(commentCreateRequest.getEventId()) != null) {
            Comment newComment = new Comment();
            newComment.setUser(userService.getOneUser(commentCreateRequest.getUserId()));
            newComment.setEvent(eventService.GetOneEvent(commentCreateRequest.getEventId()));
            newComment.setText(commentCreateRequest.getText());
            newComment.setDateTime(commentCreateRequest.getDateTime());
            return commentRepository.save(newComment);
        }
        return null;
    }

    public Comment updateOneComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment= commentRepository.findById(commentId);
        if (comment.isPresent()){
            Comment newComment= new Comment();
            newComment=comment.get();
            newComment.setText(commentUpdateRequest.getText());
            newComment.setDateTime(commentUpdateRequest.getDateTime());
            return commentRepository.save(newComment);
        }
        return null;
    }
}