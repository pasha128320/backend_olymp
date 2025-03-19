package com.itmo.olymp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Long id;
    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="worker_id")
    private Worker worker;
//    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "animal")
//    List<IllnessDiary> illnessDiaries = new ArrayList<>();

    public boolean equals(Animal animal){
        if(animal.getId().equals(this.getId())) return true;
        else return false;
    }
}
