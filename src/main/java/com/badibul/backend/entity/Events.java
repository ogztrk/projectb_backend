package com.badibul.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "events")

public class Events implements Serializable {

    @Id
    @GeneratedValue
    Long id;
    @ManyToOne(fetch = FetchType.EAGER)  /* bu tabloyu çektiğimde ilgili user gelmesin diye*/
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    User user;
    String title;

    @Column(columnDefinition = "text")
    String text;
    LocalDateTime baslangicTarihi;
    LocalDateTime bitisTarihi;

    boolean isActive;

//    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
//    @JoinTable(name = "event_categories",
//    joinColumns = {
//            @JoinColumn(name = "event_id",referencedColumnName = "id",
//            nullable = false,updatable = false)},
//               inverseJoinColumns = {
//
//
//            @JoinColumn(name = "category_id",referencedColumnName = "id",
//            nullable = false,updatable = false)})
//    @JsonIgnore
//    Set<Category> categories= new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)  /* bu tabloyu çektiğimde ilgili user gelmesin diye*/
    @JoinColumn(name = "category_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    Category category;
}
