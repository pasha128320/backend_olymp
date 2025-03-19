package com.itmo.olymp.services.impl;

import com.itmo.olymp.dto.AnimalDto;
import com.itmo.olymp.dto.WorkerDto;
import com.itmo.olymp.entities.Animal;
import com.itmo.olymp.entities.Worker;
import com.itmo.olymp.repositories.WorkerRepository;
import com.itmo.olymp.services.AnimalService;
import com.itmo.olymp.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    WorkerRepository workerRepository;
    AnimalServiceImpl animalService;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository, AnimalServiceImpl animalService) {
        this.workerRepository = workerRepository;
        this.animalService = animalService;
    }

    public WorkerServiceImpl() {}

    @Override
    public void addWorker(WorkerDto dto) {
        Worker worker = new Worker();
        worker.setFirstName(dto.getFirstName());
        worker.setLastName(dto.getLastName());
        worker.setAnimals(new ArrayList<>());

        workerRepository.save(worker);
    }

    @Override
    public void deleteWorkerById(Long id) {
        animalService.deleteAllAnimalsByWorkerId(id);
        workerRepository.deleteById(id);
    }

    @Override
    public void addAnimalToWorker(Long workerId, Long animalId) {
        Worker worker = findWorkerById(workerId);
        Animal animal = animalService.findAnimalById(animalId);
        List<Animal> animals = worker.getAnimals();
        if(animals.indexOf(animal) == -1) animals.add(animal);
        worker.setAnimals(animals);
        workerRepository.save(worker);
    }

    @Override
    public Worker findWorkerById(Long id) {
        return workerRepository.findById(id).get();
    }


}
