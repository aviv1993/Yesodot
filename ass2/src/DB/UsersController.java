package DB;

import Logic.Entities.User;

public interface UsersController {
    boolean addUser(User user);
    boolean setUSerDetails(User user);
    User getUser(String uid);
    boolean isValidUser(String uid);
    boolean isStudent(String uid);
}
