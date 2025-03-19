package com.itmo.olymp.controllers;

import com.itmo.olymp.dto.IllnessDiaryDto;
import com.itmo.olymp.entities.IllnessDiary;
import com.itmo.olymp.services.IllnessDiaryService;
import com.itmo.olymp.services.impl.IllnessDiaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diary")
public class IllnessDiaryController {

    IllnessDiaryServiceImpl illnessDiaryService;

    @Autowired
    public IllnessDiaryController(IllnessDiaryServiceImpl illnessDiaryService) {
        this.illnessDiaryService = illnessDiaryService;
    }

    @PostMapping("/")
    public void addNewRecordToDiary(@RequestBody IllnessDiaryDto dto){
        illnessDiaryService.addNewRecord(dto);
    }
}
