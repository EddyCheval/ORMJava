package fr.epsi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.*;
import org.hibernate.annotations.Cascade;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user" ,
        indexes = {
                @Index(name = "mailIndex",columnList = "mail",unique = true)
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String mail;
    @Column()
    //nullable = false
    private Date birthday;

    @Transient
    private int age;

    @OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Tweet> tweets;

    @OneToMany( fetch = FetchType.EAGER)
    private List<User> followers;

    @OneToMany(fetch = FetchType.EAGER)
    private List<User> subscriptions;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        Calendar blyat = Calendar.getInstance();
        blyat.setTime(birthday);
        this.birthday = birthday;
        this.age = Calendar.getInstance().get(Calendar.YEAR) - blyat.get(Calendar.YEAR);
    }

    public int getAge() {
        return age;
    }

    public String getMail() { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<User> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void  addFollowers(User user){
        this.followers.add(user);
    }

    public void  addSubscriptions(User user){
        this.subscriptions.add(user);
    }
}
