package com.codecool.funfact.controller;

import com.codecool.funfact.service.FunfactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunfactController {

    @Autowired
    FunfactService funfactService;

    @GetMapping("/random-jokes")
    public String getRandomJoke() {
        return funfactService.getRandomJoke();
    }

}
