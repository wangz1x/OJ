package com.wzx.leetcode;

import java.util.*;

public class Leetcode355 {

    // 记录各个用户收到的推文编号
    Map<Integer, List<Integer>> tweets = new HashMap<>();
    // 记录各个用户的关注列表       关注了谁
    Map<Integer, List<Integer>> follows = new HashMap<>();
    // 记录各个用户被关注的列表     被谁关注
    Map<Integer, List<Integer>> followers = new HashMap<>();

    public static void main(String[] args) {
        Leetcode355 l = new Leetcode355();
        l.postTweet(1,5);
        System.out.println(l.getNewsFeed(1));
        l.follow(1,2);
        l.postTweet(2, 6);
        System.out.println(l.getNewsFeed(1));
        l.unfollow(1,2);
        System.out.println(l.getNewsFeed(1));
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        System.out.println(userId + " post " + tweetId);
        // 先处理该用户自己
        if (tweets.containsKey(userId)) {           // 如果推文列表中包含该用户，
            tweets.get(userId).add(0, tweetId);  //   说明他之前收到过，直接放
        } else {                                    // 否则就创建一个消息列表
            List<Integer> list = new LinkedList<>();
            list.add(0, tweetId);
            tweets.put(userId, list);
        }
        // 再来处理关注他的人
        if (followers.containsKey(userId)) {    // 在推送到关注他的人那边去，
            for (int uid : followers.get(userId)) {       // 开始遍历关注userId的人
                if (tweets.containsKey(uid)) {            // 同理如果之前收到信息，
                    tweets.get(uid).add(0, tweetId);   // 就直接放
                } else {                                  // 否则先给他创建一个消息列表
                    List<Integer> list = new LinkedList<>();
                    list.add(0, tweetId);
                    tweets.put(uid, list);
                }
            }
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>(10);
        if (tweets.containsKey(userId)) {
            List<Integer> history = tweets.get(userId);
            int count = 0;
            for (int his : history) {
                if (count == 10) break;
                res.add(his);
                count++;
            }
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        System.out.println(followerId + " follows " + followeeId);
        if (followerId == followeeId) return;
        if (follows.containsKey(followerId)) {
            follows.get(followerId).add(followeeId);
        } else {
            List<Integer> ffff = new LinkedList<>();
            ffff.add(followeeId);
            follows.put(followerId, ffff);
        }

        if (followers.containsKey(followeeId)) {
            followers.get(followeeId).add(followerId);
        } else {
            List<Integer> ffff = new LinkedList<>();
            ffff.add(followerId);
            followers.put(followeeId, ffff);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        System.out.println(followerId + " unfollows " + followeeId);

        if (followerId == followeeId) return;
        if (follows.containsKey(followerId)) {
            follows.get(followerId).removeIf(id -> id == followeeId);
        }

        if (followers.containsKey(followeeId)) {
            followers.get(followeeId).removeIf(id -> id == followerId);
        }
        List<Integer> remove = null;
        if (tweets.containsKey(followeeId)) {         // 先取得其发的所有消息
            remove = tweets.get(followeeId);
        }
        if (remove != null && tweets.containsKey(followerId)) {
            tweets.get(followerId).removeIf(remove::contains);
        }

    }
}
