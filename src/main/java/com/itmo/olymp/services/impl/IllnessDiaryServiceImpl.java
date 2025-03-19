package com.itmo.olymp.services.impl;

import com.itmo.olymp.dto.IllnessDiaryDto;
import com.itmo.olymp.entities.Animal;
import com.itmo.olymp.entities.IllnessDiary;
import com.itmo.olymp.repositories.AnimalRepository;
import com.itmo.olymp.repositories.IllnessDiaryRepository;
import com.itmo.olymp.services.IllnessDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IllnessDiaryServiceImpl implements IllnessDiaryService {

    IllnessDiaryRepository illnessDiaryRepository;
    AnimalRepository animalRepository;

    @Autowired
    public IllnessDiaryServiceImpl(IllnessDiaryRepository illnessDiaryRepository, AnimalRepository animalRepository) {
        this.illnessDiaryRepository = illnessDiaryRepository;
        this.animalRepository = animalRepository;
    }

    @Override
    public void addNewRecord(IllnessDiaryDto dto) {
        IllnessDiary illnessDiary = new IllnessDiary();
        illnessDiary.setDiagnosis(dto.getDiagnosis());
        Animal animal = animalRepository.findById(dto.getAnimal().getId()).get();

//        List<IllnessDiary> illnessDiaryList = animal.getIllnessDiaries();
//        illnessDiaryList.add(illnessDiary);
//        animalRepository.save(animal);

        illnessDiary.setAnimal(animal);
        illnessDiaryRepository.save(illnessDiary);
    }
}
