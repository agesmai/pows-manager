package com.pows.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pows.entity.User;

public class JsonBuilder {
    public static void main(String[] args) {
        User usr = new User("test2", "Hpt123456", "enable");
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(usr);
        System.out.println("Json String: " + json);
    }
}
