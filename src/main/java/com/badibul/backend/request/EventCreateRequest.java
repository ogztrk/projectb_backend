package com.badibul.backend.request;


import com.badibul.backend.entity.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
