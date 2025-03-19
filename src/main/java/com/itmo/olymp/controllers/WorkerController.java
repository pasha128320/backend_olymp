package com.itmo.olymp.controllers;

import com.itmo.olymp.dto.AnimalDto;
import com.itmo.olymp.dto.WorkerDto;
import com.itmo.olymp.services.WorkerService;
import com.itmo.olymp.services.impl.WorkerServiceImpl;
import com.oracle.svm.core.annotate.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    WorkerServiceImpl workerService;

    @Autowired
    public WorkerController(WorkerServiceImpl workerService) {
        this.workerService = workerService;
    }

    @PostMapping("/")
    public void addNewWorker(@RequestBody WorkerDto dto){
        workerService.addWorker(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWorkerById(@PathVariable(name="id") Long id){
        workerService.deleteWorkerById(id);
    }

}
