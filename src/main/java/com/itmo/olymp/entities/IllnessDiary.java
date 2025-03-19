package com.itmo.olymp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="illness_diary")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IllnessDiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="illness_id")
    private Long id;
    @Column(name="diagnosis")
    private String diagnosis;
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

}
