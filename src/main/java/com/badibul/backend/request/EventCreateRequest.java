package com.badibul.backend.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventCreateRequest {
    Long id;
    Long userId;
    String title;
    String text;
    LocalDateTime baslangicTarihi;
    LocalDateTime bitisTarihi;

    boolean isActive;
    Long categoryId;

}
