package com.codecool.funfact.service;

import com.codecool.funfact.model.FunfactResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;


@Service
public class FunfactService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${funfact.url}")
    public String funFactUrl;

    public String getRandomJoke() {
        FunfactResult funfactResult = restTemplate.getForEntity(funFactUrl, FunfactResult.class).getBody();
        return Objects.requireNonNull(funfactResult).getValue();
    }

}
