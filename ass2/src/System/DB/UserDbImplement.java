package System.DB;

import System.Logic.Entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserDbImplement implements UsersController{

    Map<String,User> users;

    public UserDbImplement(){
        users=new HashMap<>();
    }
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
    public boolean isValidUser(String userName,String pass) {
        User user = users.get(userName);
        return user!=null && user.isTheSamePAss(pass);
    }

    @Override
    public boolean isStudent(String uid) {
        return users.containsKey(uid) && users.get(uid).isStudent();
    }
}
