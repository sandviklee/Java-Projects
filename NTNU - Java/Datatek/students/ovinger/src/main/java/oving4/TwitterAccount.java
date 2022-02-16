package oving4;

import java.util.ArrayList;

public class TwitterAccount {
    private String username;
    private ArrayList<TwitterAccount> followList = new ArrayList<>();
    private ArrayList<Tweet> tweetList = new ArrayList<>();
    private ArrayList<Tweet> retweetList = new ArrayList<>();

    public TwitterAccount(String username) {
        this.username = username;
    }
    
    public String getUserName() {
        return username;
    }

    public void follow(TwitterAccount account) {
        if (account != null) {
            followList.add(account);
        }
    }

    public void unfollow(TwitterAccount account) {
        if (followList.contains(account)) {
            followList.remove(account);
        }
    }

    public boolean isFollowing(TwitterAccount account) {
        return followList.contains(account);
    }

    public boolean isFollowedBy(TwitterAccount account) {
        return account.followList.contains(this);
    }

    public void tweet(String text) {
        tweetList.add(new Tweet(this, text));
    }

    public void retweet(Tweet tweet) {
        (tweet.getOwner()).retweetList.add(new Tweet(this, tweet));
        tweetList.add(new Tweet(this, tweet).getOriginalTweet());

    }

    public Tweet getTweet(int i) {
        return tweetList.get(Math.abs((i) - tweetList.size()));
    }

    public int getTweetCount() {
        return tweetList.size();
    }

    public int getRetweetCount() {
        return retweetList.size();
    }

    public static void main(String[] args) {
        TwitterAccount simonsle = new TwitterAccount("simonsle");
        TwitterAccount fridaskog = new TwitterAccount("fridaskog");
        TwitterAccount sverre = new TwitterAccount("Sverre");
        simonsle.tweet("Kvitre!");
        System.out.println(simonsle.getTweetCount());
        fridaskog.retweet(simonsle.getTweet(1));
        System.out.println(fridaskog.getTweetCount());
        System.out.println(simonsle.getTweet(1));
        sverre.retweet(fridaskog.getTweet(1));
        System.out.println(simonsle.getRetweetCount());
        System.out.println(sverre.getTweetCount());
        System.out.println(sverre.getRetweetCount());
        System.out.println(fridaskog.getRetweetCount());
        System.out.println(fridaskog.getTweetCount());
        
   
        
    
    }
}
