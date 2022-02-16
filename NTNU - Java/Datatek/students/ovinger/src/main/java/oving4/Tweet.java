package oving4;

import java.util.ArrayList;

public class Tweet {
    private TwitterAccount account;
    private String twitterTekst;
    private Tweet origTweet;
    private int retweetCount;
    // private ArrayList<ArrayList<Tweet> > tweetList = new ArrayList<ArrayList<Tweet>>();

    public Tweet(TwitterAccount account, String twitterTekst) {
        this.account = account;
        this.twitterTekst = twitterTekst;
        this.origTweet = this;
    }

    public Tweet(TwitterAccount account, Tweet origTweet) {
        if (account != origTweet.account) {
            this.account = account;
            this.twitterTekst = origTweet.twitterTekst;
            this.origTweet = origTweet;
            origTweet.retweetCount += 1;
        } else {
            throw new IllegalArgumentException("Kan ikke retweete seg selv.");
        }

    }

    public String getText() {
        return twitterTekst;
    }

    public TwitterAccount getOwner() {
        return account;
    }

    public Tweet getOriginalTweet() {
        if (origTweet != null) {
            return origTweet;
        } else {
            return null;
        }
    }

    public int getRetweetCount() {
        return retweetCount;
    }
    public static void main(String[] args) {
        // Tweet t1 = new Tweet("simonsle", "Dayum daniel");
        // Tweet t2 = new Tweet("simonsle", t1);
        // System.out.println(t.getRetweetCount());
    }
}
