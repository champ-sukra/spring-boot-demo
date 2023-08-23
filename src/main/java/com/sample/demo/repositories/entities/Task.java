package com.sample.demo.repositories.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String title;
}