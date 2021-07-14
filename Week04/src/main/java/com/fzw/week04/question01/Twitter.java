package com.fzw.week04.question01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fzw
 * @description 355. 设计推特
 * @date 2021-07-14
 **/
public class Twitter {

    private final Map<Integer, Set<Integer>> relation;
    private final Map<Integer, Set<Tweet>> tweet;


    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        this.relation = new HashMap<>();
        this.tweet = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     * 创建一条新的推文
     */
    public void postTweet(int userId, int tweetId) {
        this.tweetCheck(userId);
        this.relationCheck(userId);
        this.tweet.get(userId).add(new Tweet(tweetId));

    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     * 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
     */
    public List<Integer> getNewsFeed(int userId) {
        this.tweetCheck(userId);
        this.relationCheck(userId);
        Set<Integer> integers = this.relation.get(userId);
        Set<Integer> temp = new TreeSet<>(integers);
        temp.add(userId);
        return temp.parallelStream().flatMap(id -> this.tweet.get(id).stream()).sorted().limit(10).map(Tweet::getId).collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     * 关注一个用户
     */
    public void follow(int followerId, int followeeId) {
        this.tweetCheck(followerId);
        this.relationCheck(followerId);
        this.tweetCheck(followeeId);
        this.relationCheck(followeeId);
        this.relation.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     * 取消关注一个用户
     */
    public void unfollow(int followerId, int followeeId) {
        this.relation.get(followerId).remove(followeeId);
    }

    private void tweetCheck(int userId) {
        if (!this.tweet.containsKey(userId)) {
            this.tweet.put(userId, new HashSet<>());
        }
    }

    private void relationCheck(int followerId) {
        if (!this.relation.containsKey(followerId)) {
            this.relation.put(followerId, new HashSet<>());
        }
    }

    public static class Tweet implements Comparable<Tweet> {
        private final int id;
        private final long timestamp;

        public Tweet(int id) {
            this.id = id;
            this.timestamp = System.nanoTime();
        }

        public int getId() {
            return id;
        }

        public long getTimestamp() {
            return timestamp;
        }

        @Override
        public int compareTo(Tweet o) {
            return Long.compare(o.getTimestamp(), this.getTimestamp());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Tweet tweet = (Tweet) o;
            return id == tweet.id && timestamp == tweet.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, timestamp);
        }

        @Override
        public String toString() {
            return "Tweet{" +
                    "id=" + id +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }
}
