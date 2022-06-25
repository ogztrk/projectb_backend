package com.badibul.backend.response;

import com.badibul.backend.entity.Like;
import lombok.Data;

@Data
public class LikeResponse {
    Long id;
    Long userId;
    Long eventId;


    public LikeResponse(Like entity){
        this.id=entity.getId();
        this.userId=entity.getUser().getId();
        this.eventId=entity.getEvent().getId();
    }
}
