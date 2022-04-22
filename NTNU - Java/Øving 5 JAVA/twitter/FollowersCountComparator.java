package oving5.twitter;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<oving5.twitter.TwitterAccount> {

    @Override
    public int compare(TwitterAccount o1, TwitterAccount o2) {
        if (o1.getFollowersCount() > o2.getFollowersCount()) {
            return -1;
        }
        else if (o1.getFollowersCount() < o2.getFollowersCount()) {
            return 1;
        }
        return 0;
    }
    
}
