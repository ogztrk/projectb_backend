package com.badibul.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "events")

public class Events {

    @Id
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)  /* bu tabloyu çektiğimde ilgili user gelmesin diye*/
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;
    String title;

    @Column(columnDefinition = "text")
    String text;
    LocalDateTime baslangicTarihi;
    LocalDateTime bitisTarihi;

    boolean isActive;
}
