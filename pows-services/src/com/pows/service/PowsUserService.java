package com.pows.service;

import com.pows.objects.User;
import com.pows.operations.UserOpsImpl;

import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// The Java class will be hosted at the URI path "/api"
@Path("/user")
public class PowsUserService {

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "This is POWS User Service Root Path";
    }

    @GET
    @Path("list/all")
    @Produces("application/json")
    public List<User> getUsers() {
        UserOpsImpl ops = new UserOpsImpl();
        List<User> list_usr = ops.getAllUsers();
        return new ArrayList<>(list_usr);
    }


    @GET
    @Path("list/batch")
    @Produces("application/json")
    public List<User> getUserListWithLimit(@QueryParam("fromUid") int fromUid, @QueryParam("limit") int limitRecord) {
        UserOpsImpl ops = new UserOpsImpl();
        List<User> list_usr = ops.getUserListWithLimit(fromUid, limitRecord);
        return new ArrayList<>(list_usr);
    }

    @GET
    @Path("list/query")
    @Produces("application/json")
    public List<User> getUserListByUid(@QueryParam("fromUid") int fromUid, @QueryParam("toUid") int toUid) {
        UserOpsImpl ops = new UserOpsImpl();
        List<User> list_usr = ops.getUserListByUid(fromUid, toUid);
        return new ArrayList<>(list_usr);
    }

    @GET
    @Path("{login}")
    @Produces("application/json")
    public User getUserByLogin(@PathParam("login") String login) {
        UserOpsImpl ops = new UserOpsImpl();
        return ops.getUserByLogin(login);
    }

    @GET
    @Path("{login}/uid")
    @Produces("application/json")
    public int getUidByLogin(@PathParam("login") String login) {
        UserOpsImpl ops = new UserOpsImpl();
        return ops.getUserId(login);
    }

    @POST
    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public User createNewUser(User newUser) {
        UserOpsImpl ops = new UserOpsImpl();
        return ops.createUser(newUser);
    }

    @PUT
    @Path("{uid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public User updateUser(@PathParam("uid") int uid, User replaceUser) {
        UserOpsImpl ops = new UserOpsImpl();
        return ops.updateUser(uid, replaceUser);
    }

    @PATCH
    @Path("{login}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public User modifyUser(@PathParam("login") String login, JsonObject attributes) {
        UserOpsImpl ops = new UserOpsImpl();
        return ops.modifyUser(login, attributes);
    }

    @DELETE
    @Path("{uid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public String deleteUser(@PathParam("uid") int uid, User deleteUser) {
        UserOpsImpl ops = new UserOpsImpl();
        if (ops.deleteUser(uid)) {
            return "User has been deleted !!!";
        } else {
            return "User has been deleted !!!";
        }
    }


}
