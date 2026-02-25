package com.teay.security.models;

import com.teay.security.dtos.UserRequest;
import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;
    private String password;

    public Users() {
    }

    public Users(UserRequest request) {
        this.username = request.getUsername();
        this.password = request.getPassword();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
