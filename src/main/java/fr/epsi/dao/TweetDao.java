package fr.epsi.dao;

import fr.epsi.model.Tweet;

import org.hibernate.query.Query;
import java.util.List;


public class TweetDao extends AbstractDao<Tweet> {

    public void rq(){
        this.start();
        //Si sa marche c la premier fois que je vois un truc aussi bien sur java !!!!
        Query q = this.getSession().createQuery("from Tweet  where message in (:hashtags)");
        //AH ba non c de la merde
        q.setParameterList("hashtags", new String[]{"Pierre","LE"});
        for (Tweet tw:(List<Tweet>) q.list()
             ) {
            System.out.println(tw.getId());
        }
    }
}
