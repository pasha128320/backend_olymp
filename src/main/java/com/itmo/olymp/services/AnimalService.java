package com.itmo.olymp.services;

import com.itmo.olymp.dto.AnimalDto;
import com.itmo.olymp.entities.Animal;

import java.util.List;

public interface AnimalService {

    void deleteAllAnimalsByWorkerId(Long workerId);
    Animal findAnimalById(Long id);
    void saveAllAnimals(List<Animal> animals);
    void addNewAnimal(AnimalDto dto);
    void deleteAnimalById(Long id);
    List<Animal> getAllAvailableAnimals();
    void setWorkerForAnimal(Long animalId, Long workerId);
}
