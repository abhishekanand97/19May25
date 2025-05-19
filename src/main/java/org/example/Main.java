package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        Twitter twitter = new Twitter();

        twitter.postTweet(101, 1);
        twitter.postTweet(101, 2);
        twitter.postTweet(102, 3);
        twitter.postTweet(103, 4);

        twitter.follow(102, 101);
        twitter.follow(102, 103);



        List<Integer> tweets = twitter.getNewsFeed(102);

        System.out.println(tweets);

        twitter.follow(101, 102);
        twitter.follow(101, 103);
        System.out.println(twitter.getNewsFeed(101));

        twitter.unfollow(101, 102);
        System.out.println(twitter.getNewsFeed(101));

    }
}

/*
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.
Implement the Twitter class:
Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.


Tweet // id , timestamp
User
FollowersMap<


 */

