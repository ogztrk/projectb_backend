package com.badibul.backend.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentCreateRequest {
    Long id;
    Long eventId;
    Long userId;
    String text;
    LocalDateTime dateTime;

}
