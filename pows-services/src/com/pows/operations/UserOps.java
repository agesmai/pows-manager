package com.pows.operations;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pows.entity.PowsPatchData;
import com.pows.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserOps {

    // CREATE User Function (@POST)
    User createUser(User newUser);

    // READ User Function (@GET)
    int getUserId(String login);

    User getUserByUid(int uid);

    User getUserByLogin(String login);

    List<User> getAllUsers();

    List<User> getUserListWithLimit(int fromUid, int limitRecord);

    List<User> getUserListByUid(int fromUid, int toUid);

    // UPDATE User Function (@PUT) -- Only using when replace user record
    User updateUser(int uid, User replaceUser);

    // MODIFY User Function (@PATCH) -- Using when modify attributes
    User modifyUser(String login, ArrayList<PowsPatchData> operations);

    // Revoke User Function (@PATCH) -- Change status to "revoked" instead delete user from db
    Boolean revokeUser(String login);

    Boolean enableUser(String login);

    Boolean disableUser(String login);

    Boolean resetPassword(String password);

    Boolean changePassword(String oPassword, String nPassword);

    Boolean setRandomPassword();

    // DELETE User Function (@DELETE)
    Boolean deleteUser(int uid);
}
