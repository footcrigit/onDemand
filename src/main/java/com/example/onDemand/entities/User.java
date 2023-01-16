package com.example.onDemand.entities;

import com.example.onDemand.user.UserId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @EmbeddedId
    private UserId userId;

    @Column(name = "username")
    private String userName;

    public User() {
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(UserId userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
