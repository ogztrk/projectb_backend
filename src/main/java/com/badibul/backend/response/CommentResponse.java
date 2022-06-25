package com.badibul.backend.response;

import com.badibul.backend.entity.Comment;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponse {
    Long id;
    Long eventId;
    Long userId;
    String text;
    LocalDateTime dateTime;

    public CommentResponse(Comment entity){
        this.id=entity.getId();
        this.eventId=entity.getEvent().getId();
        this.userId=entity.getUser().getId();
        this.text=entity.getText();
        this.dateTime=entity.getDateTime();
    }
}
