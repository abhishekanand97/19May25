package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TweetRepository{
    
    List<Tweet> tweets = new ArrayList<Tweet>();
    HashMap<Integer, ArrayList<Tweet>> usersTweetsMap = new HashMap<>();
    Tweet getTweetById(int tweetId){
        return  null;
    }

    ArrayList<Tweet> getTweetsByUserId(int userId){
        return  usersTweetsMap.getOrDefault(userId, new ArrayList<Tweet>());
    }
    
    void addTweet(Tweet tweet){
        if(!usersTweetsMap.containsKey(tweet.userId)){
            usersTweetsMap.put(tweet.userId, new ArrayList<>());
        }
        usersTweetsMap.get(tweet.userId).add(tweet);
    }
    
}
