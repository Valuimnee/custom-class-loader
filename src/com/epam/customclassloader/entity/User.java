package com.epam.customclassloader.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Tsalapava Maryia
 * @version 1.0, 4/25/2018
 */
public class User implements Serializable, Cloneable {
    private static final long serialVersionUID = 8692280407084619440L;

    private long id;
    private String login;
    private String password;
    private boolean active;

    public User() {
    }

    public User(long id, String login, String password, boolean active) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                active == user.active &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, active);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}
