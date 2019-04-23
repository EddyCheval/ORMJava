package fr.epsi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tweet")
public class Tweet {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
