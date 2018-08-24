package com.pows.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pows.entity.PowsResponse;
import com.pows.entity.User;

import java.util.ArrayList;

public class JsonBuilder {
    public static void test(String[] args) {
        User usr = new User("test", "Hpt123456", "enable");
        User usr1 = new User("test1", "Hpt123456", "enable");
        User usr2 = new User("test2", "Hpt123456", "enable");
        ArrayList<User> list_user = new ArrayList<>();
        list_user.add(usr1);
        list_user.add(usr2);
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(usr);

        System.out.println("Json String: " + json);
        PowsResponse pr = new PowsResponse();
        pr.setStatus("success");
        pr.setMessage("test");
        pr.setCode(101);
        JsonObject user_data = new JsonObject();
        JsonObject users_data = new JsonObject();
        user_data.add("user", gson.toJsonTree(usr));
        user_data.add("users", gson.toJsonTree(list_user));

        pr.setData(user_data);
        System.out.println("Json String: " + pr.toJsonString());
    }
}
