package com.badibul.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    Long id;

    String name;

    String foto;
    @JsonIgnore
    @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY)
    Set<Events>events=new HashSet<>();
}
