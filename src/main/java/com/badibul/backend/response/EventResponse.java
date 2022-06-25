package com.badibul.backend.response;

import com.badibul.backend.entity.Events;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventResponse {

    Long id;
    Long userId;
    Long categoryId;
    String title;
    String userName;
    String categoryName;
    String text;
    LocalDateTime baslangicTarihi;
    LocalDateTime bitisTarihi;
    List<LikeResponse> eventLikes;


    public EventResponse(Events entity,List<LikeResponse>likes){
        this.id=entity.getId();
        this.userId=entity.getUser().getId();
        this.categoryId=entity.getCategory().getId();
        this.title=entity.getTitle();
        this.userName=entity.getUser().getName();
        this.categoryName=entity.getCategory().getName();
        this.text=entity.getText();
        this.baslangicTarihi=entity.getBaslangicTarihi();
        this.bitisTarihi=entity.getBitisTarihi();
        this.eventLikes=likes;
    }

}
