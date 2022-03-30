package com.badibul.backend.request;

import lombok.Data;

@Data
public class LikeCreateRequest {

    Long id;
    Long eventId;
    Long userId;
}
