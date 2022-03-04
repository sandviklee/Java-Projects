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
        tweet.retweetCount += 1;
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

    

    @Override
    public String toString() {
        return ""+ username + "";
    }

    public static void main(String[] args) {
        TwitterAccount simonsle = new TwitterAccount("simonsle");
        TwitterAccount olav = new TwitterAccount("Olav");
        TwitterAccount sverre = new TwitterAccount("Sverre");
        simonsle.tweet("Kvitre!");
        System.out.println(simonsle.getTweetCount());
        olav.retweet(simonsle.getTweet(1));
        System.out.println(olav.getTweetCount());
        System.out.println(simonsle.getTweet(1));
        sverre.retweet(olav.getTweet(1));
        System.out.println(simonsle.getRetweetCount());
        System.out.println(sverre.getTweetCount());
        System.out.println(sverre.getRetweetCount());
        System.out.println(olav.getRetweetCount());
        System.out.println(olav.getTweetCount());
        
   
        
    
    }
}
