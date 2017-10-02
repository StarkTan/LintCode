package com.stark._501_600._501_510;

import com.stark._1_100._1_10.LintCode_1;
import com.stark.entity.Tweet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stark on 2017/10/2.
 * 实现一个迷你的推特，支持下列几种方法
 * 1.postTweet(user_id, tweet_text). 发布一条推特.
 * 2.getTimeline(user_id). 获得给定用户最新发布的十条推特，按照发布时间从最近的到之前排序
 * 3.getNewsFeed(user_id). 获得给定用户的朋友或者他自己发布的最新十条推特，从发布时间最近到之前排序
 * 4.follow(from_user_id, to_user_id). from_user_id 关注 to_user_id.
 * 5.unfollow(from_user_id, to_user_id). from_user_id 取消关注 to_user_id.
 */
public class LintCode_501 {

    List<Tweet> list = null;
    Map<Integer, List<Integer>> map;

    public LintCode_501() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        // write your code here
        Tweet tweet = Tweet.create(user_id, tweet_text);
        this.list.add(0, tweet);
        if (!this.map.containsKey(user_id)) {
            List<Integer> list = new ArrayList<>();
            list.add(user_id);
            this.map.put(user_id, list);
        }
        return tweet;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        // write your code here
        List<Tweet> res = new ArrayList<>();
        List<Integer> users = this.map.get(user_id);
        if (users == null) {
            return res;
        }
        for (Tweet tweet : this.list) {
            if (users.contains(tweet.user_id)) {
                res.add(tweet);
            }
            if (res.size() == 10) {
                break;
            }
        }
        return res;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        // write your code here
        List<Tweet> res = new ArrayList<>();
        for (Tweet tweet : this.list) {
            if (tweet.user_id == user_id) {
                res.add(tweet);
            }
            if (res.size() == 10) {
                break;
            }
        }
        return res;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        // write your code here
        if (this.map.containsKey(from_user_id)) {
            this.map.get(from_user_id).add(to_user_id);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(from_user_id);
            list.add(to_user_id);
            this.map.put(from_user_id, list);
        }
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
        if (this.map.containsKey(from_user_id)) {
            this.map.get(from_user_id).remove(new Integer(to_user_id));
        }
    }
}
