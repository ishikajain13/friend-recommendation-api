package com.ishika.friend_recommendation_api.Controller;
import com.ishika.friend_recommendation_api.model.Recommendation;
import com.ishika.friend_recommendation_api.Service.SocialNetworkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SocialNetworkController {

    private final SocialNetworkService service;

    public SocialNetworkController(SocialNetworkService service) {
        this.service = service;
    }

    // Add user
    @PostMapping("/users")
    public String addUser(@RequestParam String name) {
        service.addUser(name);
        return "User added: " + name;
    }

    // Add friendship
    @PostMapping("/friends")
    public String addFriend(@RequestParam String u1, @RequestParam String u2) {
        service.addFriend(u1, u2);
        return "Friendship added";
    }

    // Get recommendations
    @GetMapping("/recommendations/{user}")
    public List<Recommendation> recommend(@PathVariable String user) {
        return service.recommendFriends(user);
    }
}