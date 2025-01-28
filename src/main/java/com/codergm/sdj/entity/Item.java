package com.codergm.sdj.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate creationDate;

    private Integer price;

    public Item(String name, LocalDate creationDate, Integer price) {
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }
}
