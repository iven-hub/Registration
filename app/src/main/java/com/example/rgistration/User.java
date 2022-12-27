package com.example.rgistration;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String user;
    private String email;
    private String password;

    public String getUser() {
        return user;
    }

    public User (String user, String email, String password){
        this.user= user;
        this.email=email;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
