package com.badibul.backend.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateBasvuruRequest {

    int onay;
    LocalDateTime basvuruTarihi;
}
