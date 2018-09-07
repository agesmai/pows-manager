package com.pows.utils;

import com.google.gson.*;
import com.pows.entity.PowsPatchData;
import com.pows.entity.PowsResponse;
import com.pows.entity.User;

import java.util.ArrayList;

public class JsonBuilder {
    public static void main(String[] args) {
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
        users_data.add("users", gson.toJsonTree(list_user));
        JsonArray listU = users_data.getAsJsonArray("users");
        pr.setData(users_data);
        System.out.println("Json String: " + pr.toJsonString());
        System.out.println("Json String: " + users_data.get("users"));

        for (int i = 0; i < listU.size(); i++) {
            JsonObject user = (JsonObject) listU.get(i);
            System.out.println("User thu " + i + " :");
            System.out.println("uid: " + user.get("login"));
        }
        System.out.println("Json String: " + listU);

        PowsPatchData data1 = new PowsPatchData("replace", "/status", "disable");
        PowsPatchData data2 = new PowsPatchData("replace", "/login", "abc");
        PowsPatchData data3 = new PowsPatchData("replace", "/uid", 10);
        ArrayList<PowsPatchData> pdata = new ArrayList<>();
        pdata.add(data1);
        pdata.add(data2);
        pdata.add(data3);
        System.out.println("pdata: " + gson.toJson(pdata));
    }
}
