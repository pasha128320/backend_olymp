package com.itmo.olymp.dto;


import com.itmo.olymp.entities.Animal;
import com.itmo.olymp.entities.IllnessDiary;
import com.itmo.olymp.entities.Worker;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {

    private Long id;
    private String name;
    private Worker worker;
    private List<IllnessDiary> illnessDiaries;
}
