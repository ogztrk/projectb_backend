package com.badibul.backend.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BasvuruCreateRequest {
    Long id;
    Long userId;
    Long eventId;
    int onay;
    LocalDateTime basvuruTarihi;


}
