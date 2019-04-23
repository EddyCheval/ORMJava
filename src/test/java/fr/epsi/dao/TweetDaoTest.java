package fr.epsi.dao;

import com.sun.org.apache.xerces.internal.xs.StringList;
import fr.epsi.model.Tweet;
import fr.epsi.model.User;
import org.hibernate.query.NativeQuery;
import org.junit.Test;

import javax.persistence.Query;
import java.util.List;

public class TweetDaoTest {

    @Test
    public void insertTweet() {
        Tweet tweet = new Tweet();
        tweet.setMessage("non pas de babyfoot.Pierre NEGRE LE KON");
        User user = new UserDao().get(1);
        tweet.setUser(user);
        System.out.println(new TweetDao().save(tweet));
    }
    @Test
    public void getTweet() {
        System.out.println(new TweetDao().get(4).getMessage());
    }
    @Test
    public void rq(){

        new TweetDao().rq();
    }
}
