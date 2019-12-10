package Logic;

import Logic.Entities.STATUS;

import java.util.List;

public interface ProjectManagment {
    boolean login(String userId);
    boolean logout(String userId);
    boolean register(String userId);
    boolean addProject(String name ,String description ,String howLong ,String firstName ,String familyName ,String email, String phone, String org);
    boolean registerToProject(List<String> ids, String leaderId,Integer projectCode);
    boolean registerObserverToProjct(String uid,int projectCode,boolean phone,boolean email);
    boolean setProjectStatus(STATUS status, Integer projectCode);
}
