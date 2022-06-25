package com.badibul.backend.response;

import com.badibul.backend.entity.Basvuru;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BasvuruResponse {
    Long id;
    Long userId;
    Long eventId;
    String userName;
    LocalDateTime basvuruTarihi;
    int onay;

    public  BasvuruResponse(Basvuru entity){
        this.id=entity.getId();
        this.userId=entity.getUser().getId();
        this.eventId=entity.getEvent().getId();
        this.userName=entity.getUser().getName();
        this.basvuruTarihi=entity.getBasvuruTarihi();
        this.onay=entity.getOnay();
    }

}
