package com.pows.operations;

import com.pows.entity.User;

import javax.json.JsonObject;
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
    User modifyUser(String login, JsonObject attributes);

    // Revoke User Function (@PATCH) -- Change status to "revoked" instead delete user from db
    Boolean revokeUser(String login);

    Boolean enableUser(String login);

    Boolean disableUser(String login);

    // DELETE User Function (@DELETE)
    Boolean deleteUser(int uid);
}
