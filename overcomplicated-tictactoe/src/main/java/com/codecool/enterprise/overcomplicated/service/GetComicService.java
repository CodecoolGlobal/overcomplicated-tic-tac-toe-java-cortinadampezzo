package com.codecool.enterprise.overcomplicated.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetComicService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${comics.url}")
    private String comicUrl;

    public String getComic() {
        return restTemplate.getForEntity(comicUrl, String.class).getBody();
    }

}
