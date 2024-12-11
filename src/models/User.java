package models;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected String login;
    protected String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public abstract void displayUserInfo();
}
