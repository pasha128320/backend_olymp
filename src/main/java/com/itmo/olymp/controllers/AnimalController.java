package com.itmo.olymp.controllers;

import com.itmo.olymp.dto.AnimalDto;
import com.itmo.olymp.services.AnimalService;
import com.itmo.olymp.services.impl.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.itmo.olymp.mappers.AnimalMapper.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    AnimalServiceImpl animalService;

    @Autowired
    public AnimalController(AnimalServiceImpl animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/")
    public void addNewAnimal(@RequestBody AnimalDto dto){
        animalService.addNewAnimal(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAnimalById(@PathVariable(name="id") Long id){
        animalService.deleteAnimalById(id);
    }

    @GetMapping("/available")
    public List<AnimalDto> getAllAvailableAnimals(){
        return animalService.getAllAvailableAnimals().stream().map(animal -> mapToDto(animal)).collect(Collectors.toList());
    }
    @PutMapping("/set/worker")
    public void setWorkerForAnimal(@RequestParam(name="animalId") Long animalId
                                  ,@RequestParam(name = "workerId") Long workerId){
        animalService.setWorkerForAnimal(animalId,workerId);
    }
}
