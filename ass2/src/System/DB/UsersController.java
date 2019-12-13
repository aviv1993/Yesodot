package System.DB;

import System.Logic.Entities.User;

public interface UsersController {
    boolean addUser(User user);
    boolean setUSerDetails(User user);
    User getUser(String uid);
    boolean isValidUser(String uid,String pass);
    boolean isStudent(String uid);
}
