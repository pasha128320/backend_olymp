package com.itmo.olymp.dto;

import com.itmo.olymp.entities.Animal;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Animal> animals;
}
