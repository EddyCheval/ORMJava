package fr.epsi.dao;

import fr.epsi.model.User;
import fr.epsi.model.administrateur;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class UserDaoTest {

    @Test
    public void insertUser() {
        User user = new User();
        user.setFirstname("Benjamin");
        user.setLastname("Tourman");
        user.setMail("blyat@cyka.com");
        System.out.println(new UserDao().save(user));
    }

    @Test
    public void getUser() {
        User u = new UserDao().get(1);
        System.out.println(u.getFirstname());
    }
    @Test
    public void insertAge() {
        User user = new User();
        user.setFirstname("Benjamin");
        user.setLastname("Tourman");
        user.setMail("blyatTche@cyka.com");
        Calendar date = Calendar.getInstance();
        date.set(1998,10,2);
        user.setBirthday(date.getTime());
        System.out.println(new UserDao().save(user));
        System.out.println(user.getAge());
    }

    @Test
    public void getTweets() {
        User u = new UserDao().get(1);
        System.out.println(u.getTweets().get(0).getMessage());
    }

    @Test
    public void deleteUser() {
        User u = new UserDao().get(8);
        new UserDao().delete(u);
    }

    @Test
    public void insertUserSUB() {
        User user1 = new UserDao().get(1);
        User user2 = new UserDao().get(3);
        user1.addFollowers(user2);
        user2.addSubscriptions(user1);
        new UserDao().merge(user1);
        new UserDao().merge(user2);
    }

    @Test
    public void insertAdmin(){
        User user = new administrateur();
        user.setFirstname("Benjamin");
        user.setLastname("Tourman");
        user.setMail("blyatWOW@cyka.com");
        System.out.println(new UserDao().save(user));
    }
}
