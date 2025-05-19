package org.example;

public class Tweet implements Comparable<Tweet>{
    int tweetId;
    long timestamp;
    int userId;
    
    public Tweet(int tweetId, long timestamp, int userId){
        this.tweetId = tweetId;
        this.timestamp = timestamp;
        this.userId = userId;
    }
    
    @Override
    public int compareTo(Tweet other){
        return (int)Long.compare(this.tweetId , other.tweetId);
    }
}
