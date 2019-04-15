package com.codecool.comicsservice.service;

import com.codecool.comicsservice.model.ComicsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Random;

@Service
public class ComicsService {

    @Autowired
    private RestTemplate restTemplate;

    public String getRandomComic() {
        int comicNumber = new Random().nextInt(1929 - 1) + 1;
        String comicUrl = "https://xkcd.com/" + comicNumber + "/info.0.json";
        ComicsResult comicsResult = restTemplate.getForEntity(comicUrl, ComicsResult.class).getBody();
        return Objects.requireNonNull(comicsResult).getImg();
    }

}
