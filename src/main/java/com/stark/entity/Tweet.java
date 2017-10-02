package com.stark.entity;

/**
 * Created by Stark on 2017/10/2.
 */
public class Tweet {
    public int id;
    public int user_id;
    public String text;
    public static Tweet create(int user_id, String tweet_text) {
        // This will create a new tweet object,
        // and auto fill id
        Tweet res = new Tweet();
        res.id = 0;
        res.user_id = user_id;
        res.text = tweet_text;
        return res;
    }
}
