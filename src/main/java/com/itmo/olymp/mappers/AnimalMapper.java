package com.itmo.olymp.mappers;

import com.itmo.olymp.dto.AnimalDto;
import com.itmo.olymp.entities.Animal;

public class AnimalMapper {

    public static AnimalDto mapToDto(Animal animal){
        return AnimalDto.builder()
                .id(animal.getId())
                .name(animal.getName())
                .worker(animal.getWorker())
                .build();
    }
}
