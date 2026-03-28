package com.ishika.friend_recommendation_api.model;

public class Recommendation {
    private String name;
    private int mutualFriends;

    public Recommendation(String name, int mutualFriends) {
        this.name = name;
        this.mutualFriends = mutualFriends;
    }

    public String getName() {
        return name;
    }

    public int getMutualFriends() {
        return mutualFriends;
    }
}
