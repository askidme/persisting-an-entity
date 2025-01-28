package com.codergm.sdj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String staffId;
    private String name;
    private Double salary;

    public Guide(String staffId, String name, Double salary) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
    }
}
