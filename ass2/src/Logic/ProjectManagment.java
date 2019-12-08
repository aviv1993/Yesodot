package Logic;

import java.util.List;

public interface ProjectManagment {
    boolean login(String userId);
    boolean logout(String userId);
    boolean register(String userId);
    boolean addProject(String name ,String description ,String howLong ,String firstName ,String familyName ,String email, String phone, String org);
    boolean registerToProject(List<String> ids, String leader,String projectCode);
}
