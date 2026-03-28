package com.ishika.friend_recommendation_api.Service;
import com.ishika.friend_recommendation_api.model.Recommendation;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SocialNetworkService {

    private Map<String, Set<String>> network = new HashMap<>();

    public void addUser(String user) {
        network.putIfAbsent(user, new HashSet<>());
    }

    public void addFriend(String user1, String user2) {
        network.putIfAbsent(user1, new HashSet<>());
        network.putIfAbsent(user2, new HashSet<>());

        network.get(user1).add(user2);
        network.get(user2).add(user1);
    }

//    public Map<String, Integer> recommendFriends(String user) {
//
//        Map<String, Integer> recommendations = new HashMap<>();
//        Set<String> friends = network.getOrDefault(user, new HashSet<>());
//
//        for (String friend : friends) {
//            for (String mutual : network.get(friend)) {
//
//                if (mutual.equals(user) || friends.contains(mutual)) continue;
//
//                recommendations.put(
//                        mutual,
//                        recommendations.getOrDefault(mutual, 0) + 1
//                );
//            }
//        }
//
//        return recommendations;
//    }
public List<Recommendation> recommendFriends(String user) {

    Map<String, Integer> map = new HashMap<>();
//    Set<String> friends = network.getOrDefault(user, new HashSet<>());
    if (!network.containsKey(user)) {
        throw new RuntimeException("User not found");
    }
    Set<String> friends = network.get(user);

    for (String friend : friends) {
        for (String mutual : network.get(friend)) {

            if (mutual.equals(user) || friends.contains(mutual)) continue;

            map.put(mutual, map.getOrDefault(mutual, 0) + 1);
        }
    }

    List<Recommendation> result = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        result.add(new Recommendation(entry.getKey(), entry.getValue()));
    }

    result.sort((a, b) -> b.getMutualFriends() - a.getMutualFriends());

    return result;

}
}