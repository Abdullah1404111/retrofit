package com.example.abdullah.retrofit;

public class Hero {
    public String login;
    public Integer id;
    public String avatar_url;

    public void hero(String name,Integer id){
        this.login = login;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public  Integer getId() {
        return id;
    }

}
