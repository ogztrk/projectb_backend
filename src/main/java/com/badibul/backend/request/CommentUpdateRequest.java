package com.badibul.backend.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CommentUpdateRequest {

    String text;
    LocalDateTime dateTime;
}
