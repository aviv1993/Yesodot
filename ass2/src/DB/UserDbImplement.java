package DB;

import Logic.Entities.User;

import java.util.Map;

public class UserDbImplement implements UsersController{

    Map<String,User> users;
    @Override
    public boolean addUser(User user) {
        users.put(user.getUid(),user);
        return true;
    }

    @Override
    public boolean setUSerDetails(User user) {
        users.put(user.getUid(),user);
        return true;
    }

    @Override
    public User getUser(String uid) {
        return users.get(uid);
    }

    @Override
    public boolean isValidUser(String uid) {
        return users.containsKey(uid);
    }

    @Override
    public boolean isStudent(String uid) {
        return users.containsKey(uid) && users.get(uid).isStudent();
    }
}
