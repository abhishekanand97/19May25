package org.example;

import java.util.*;

public class Twitter{

    HashMap<Integer, HashSet<Integer>> followingMap;
    TweetRepository tweets;

    Twitter(){
        followingMap = new HashMap<>();
        tweets = new TweetRepository();
    }

    void postTweet(int userId, int tweetId){
        Tweet tweet = new Tweet(tweetId, System.currentTimeMillis(), userId);
        tweets.addTweet(tweet);
    }
    
    List<Integer> getNewsFeed(int userId){
        List<ArrayList<Tweet>> tweetsList = new ArrayList<ArrayList<Tweet>>();
        List<Integer> results = new ArrayList<>();
        for(int followee: followingMap.getOrDefault(userId, new HashSet<>())){
            if(!tweets.getTweetsByUserId(followee).isEmpty())
                tweetsList.add(tweets.getTweetsByUserId(followee));
        }

        int k = tweetsList.size();
        int LIMIT = 2;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(( a, b)-> {

            Tweet at = tweetsList.get(a[0]).get(a[1]);
            Tweet bt = tweetsList.get(b[0]).get(b[1]);

            return bt.compareTo(at);
        });

        int listIndex = 0;

        for(List<Tweet> tweetsbyFollowee: tweetsList){
            int tweetIndexInList = tweetsbyFollowee.size()-1;
            Tweet latest = tweetsbyFollowee.get(tweetsbyFollowee.size()-1);
            pq.add(new int[]{listIndex, tweetIndexInList});
            listIndex++;
        }

        while(!pq.isEmpty() && (results.size()<LIMIT)){

            int[] tweetIndices = pq.poll();
            Tweet popped = tweetsList.get(tweetIndices[0]).get(tweetIndices[1]);

            if(tweetIndices[1]>0){
                pq.add(new int[]{tweetIndices[0], tweetIndices[1]-1});
            }

            results.add(popped.tweetId);

        }

        return results;

    }

    void follow(int followerId, int followeeId){

        if(!followingMap.containsKey(followerId)){
            followingMap.put(followerId, new HashSet<>());
        }

        followingMap.get(followerId).add(followeeId);
    }
    
    void unfollow(int followerId, int followeeId){
        if(!followingMap.containsKey(followerId)){
            return;
        }

        followingMap.get(followerId).remove(followeeId);
    }
    
}



