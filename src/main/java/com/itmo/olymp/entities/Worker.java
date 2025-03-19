package com.itmo.olymp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "workers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="worker_id")
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @OneToMany(cascade = CascadeType.REFRESH)
    private List<Animal> animals = new ArrayList<>();
}
