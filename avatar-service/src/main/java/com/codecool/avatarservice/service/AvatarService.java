package com.codecool.avatarservice.service;

import org.springframework.stereotype.Service;


@Service
public class AvatarService {

    public String getAvatarByString(String avatarName) {
        return "https://robohash.org/" + avatarName + ".png";
    }

}
