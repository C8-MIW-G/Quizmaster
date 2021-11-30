package model;

import java.util.Objects;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Generic user that can log in and not much else
 */
public class User {
    // userId should be set by the database, if it is not set it is -1
    public static final int DEFAULT_USER_ID = -1;

    private int userId;
    private String username;
    private String password;

    public User(String username, String password) {
        this.userId = DEFAULT_USER_ID;
        this.username = username;
        this.password = password;
    }

    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
        this.password = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
