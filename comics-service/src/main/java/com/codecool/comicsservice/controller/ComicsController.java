package com.codecool.comicsservice.controller;

import com.codecool.comicsservice.service.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComicsController {

    @Autowired
    ComicsService comicsService;

    @GetMapping("/random-comic")
    public String getRandomComic() {
        return comicsService.getRandomComic();
    }

}
