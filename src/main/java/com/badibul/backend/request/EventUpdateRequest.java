package com.badibul.backend.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventUpdateRequest {
    String title;

    String text;
    LocalDateTime baslangicTarihi;
    LocalDateTime bitisTarihi;

    boolean isActive;

}
