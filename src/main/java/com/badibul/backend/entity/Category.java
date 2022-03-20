package com.badibul.backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.*;

@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    Long id;

    String name;

    String foto;
}
