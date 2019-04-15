package com.codecool.enterprise.overcomplicated.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetAvatarService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${avatar.url}")
    private String baseURL;

    public String getAvatar(String avatarName) {
        baseURL = "http://avatar/" + avatarName + ".png";
        return restTemplate.getForEntity(baseURL, String.class).getBody();
    }

}
