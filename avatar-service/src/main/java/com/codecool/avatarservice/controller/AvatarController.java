package com.codecool.avatarservice.controller;

import com.codecool.avatarservice.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AvatarController {

    @Autowired
    AvatarService avatarService;

    @GetMapping("/{name}.png")
    @ResponseBody
    public String getAvatarByName(@PathVariable String name) {
        return avatarService.getAvatarByString(name);
    }

}
