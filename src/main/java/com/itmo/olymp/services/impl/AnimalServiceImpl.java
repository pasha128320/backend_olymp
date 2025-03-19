package com.itmo.olymp.services.impl;

import com.itmo.olymp.dto.AnimalDto;
import com.itmo.olymp.entities.Animal;
import com.itmo.olymp.entities.IllnessDiary;
import com.itmo.olymp.entities.Worker;
import com.itmo.olymp.repositories.AnimalRepository;
import com.itmo.olymp.repositories.IllnessDiaryRepository;
import com.itmo.olymp.repositories.WorkerRepository;
import com.itmo.olymp.services.AnimalService;
import com.itmo.olymp.services.IllnessDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {

    AnimalRepository animalRepository;
    WorkerRepository workerRepository;
    IllnessDiaryRepository illnessDiaryRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository, WorkerRepository workerRepository, IllnessDiaryRepository illnessDiaryRepository) {
        this.animalRepository = animalRepository;
        this.workerRepository = workerRepository;
        this.illnessDiaryRepository = illnessDiaryRepository;
    }


    @Override
    public void deleteAllAnimalsByWorkerId(Long workerId) {
        List<Animal> animals = animalRepository.findAllByWorkerId(workerId);
        for(Animal animal : animals){
            animal.setWorker(null);
        }
        animalRepository.saveAll(animals);
    }

    @Override
    public Animal findAnimalById(Long id) {
        return animalRepository.findById(id).get();
    }

    @Override
    public void saveAllAnimals(List<Animal> animals) {
        animalRepository.saveAll(animals);
    }

    @Override
    public void addNewAnimal(AnimalDto dto) {
        Animal animal = new Animal();
        animal.setName(dto.getName());
        animalRepository.save(animal);
    }

    @Override
    public void deleteAnimalById(Long id) {
        Animal animal = findAnimalById(id);
        List<IllnessDiary> illnessDiaries = illnessDiaryRepository.findAllByAnimalId(id);
        illnessDiaryRepository.deleteAllById(illnessDiaries.stream().map(illness -> illness.getId()).collect(Collectors.toList()));
        animalRepository.deleteById(id);
    }

    @Override
    public List<Animal> getAllAvailableAnimals() {
        return animalRepository.findAllAvailableAnimals();
    }

    @Override
    public void setWorkerForAnimal(Long animalId, Long workerId) {
        Animal animal = findAnimalById(animalId);
        Worker worker = workerRepository.findById(workerId).get();
        animal.setWorker(worker);
        animalRepository.save(animal);
    }

}
