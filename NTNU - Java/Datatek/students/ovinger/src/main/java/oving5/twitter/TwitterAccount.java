package oving5.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TwitterAccount {
    private String username;
    private ArrayList<TwitterAccount> followList = new ArrayList<>();
    private ArrayList<TwitterAccount> followers = new ArrayList<>();
    private ArrayList<Tweet> tweetList = new ArrayList<>();
    private ArrayList<Tweet> retweetList = new ArrayList<>();

    public TwitterAccount(String username) {
        this.username = username;
    }

    //Lagt til ekstra konstruktør for funksjonalitet
    // public TwitterAccount(String username, int followcount) {
    //     this.username = username;
    //     for (int i=0; i<followcount; i++) {
    //         this.followList.add(new TwitterAccount("Simon" + i));
    //     }
    // }
    
    public String getUserName() {
        return username;
    }

    public void follow(TwitterAccount account) {
        if (account != null) {
            followList.add(account);
            account.followers.add(this);
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
    
    public int getFollowersCount() {
        return followers.size();
    }

    public ArrayList<TwitterAccount> getFollowList() {
        return new ArrayList<TwitterAccount>(followList);
    }

    public ArrayList<TwitterAccount> getFollowers(Comparator<TwitterAccount> comparator) {
        if (!(comparator == null)) {
            ArrayList<TwitterAccount> followersListcopy = new ArrayList<>(followers);
            Collections.sort(followersListcopy, comparator);
            return followersListcopy;
        }
        return followers;
    }

    

    @Override
    public String toString() {
        return ""+ username + "";
    }

    public static void main(String[] args) {
        // TwitterAccount simonsle = new TwitterAccount("simonsle");
        // TwitterAccount olav = new TwitterAccount("Olav");
        // TwitterAccount sverre = new TwitterAccount("Sverre");
        // simonsle.tweet("Kvitre!");
        // System.out.println(simonsle.getTweetCount());
        // olav.retweet(simonsle.getTweet(1));
        // System.out.println(olav.getTweetCount());
        // System.out.println(simonsle.getTweet(1));
        // sverre.retweet(olav.getTweet(1));
        // System.out.println(simonsle.getRetweetCount());
        // System.out.println(sverre.getTweetCount());
        // System.out.println(sverre.getRetweetCount());
        // System.out.println(olav.getRetweetCount());
        // System.out.println(olav.getTweetCount());

        
        TwitterAccount simonsle = new TwitterAccount("Simon");
        TwitterAccount Frida = new TwitterAccount("Frida");
        TwitterAccount Sverre = new TwitterAccount("Sverre");
        simonsle.follow(Frida);
        Sverre.follow(Frida);
        Sverre.follow(simonsle);

        System.out.println(Frida.getFollowersCount());
   
        
    
    }
}
