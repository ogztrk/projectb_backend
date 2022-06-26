package com.badibul.backend.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventCreateRequest {

    Long userId;
    String title;
    String text;
    LocalDateTime baslangicTarihi;
    LocalDateTime bitisTarihi;

    boolean isActive=true;
    Long categoryId;

}
