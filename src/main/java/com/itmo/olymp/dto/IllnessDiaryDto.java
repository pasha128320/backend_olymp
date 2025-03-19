package com.itmo.olymp.dto;

import com.itmo.olymp.entities.Animal;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IllnessDiaryDto {

    private Long id;
    private String diagnosis;
    private Animal animal;
}
