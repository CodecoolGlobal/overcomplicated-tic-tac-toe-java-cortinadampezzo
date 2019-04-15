package com.codecool.enterprise.overcomplicated.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetFunfactService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${funfact.url}")
    private String funfactUrl;

    public String getFunfact() {
        return restTemplate.getForEntity(funfactUrl, String.class).getBody();
    }

}
