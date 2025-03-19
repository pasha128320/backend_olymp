package com.itmo.olymp.services;

import com.itmo.olymp.dto.AnimalDto;
import com.itmo.olymp.dto.WorkerDto;
import com.itmo.olymp.entities.Worker;

public interface WorkerService {

    void addWorker(WorkerDto dto);
    void deleteWorkerById(Long id);
    void addAnimalToWorker(Long workerId, Long animalId);
    Worker findWorkerById(Long id);
}
