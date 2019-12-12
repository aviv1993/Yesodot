package Logic;

import Logic.Entities.Project;
import Logic.Entities.STATUS;

import java.util.List;

public interface ProjectManagment {
    boolean login(String name, String pass);
    boolean logout(String name);
    boolean register(String name,String pass,boolean isStudent);

    int addProject(String userName, String name ,String description ,String howLong ,String firstName ,String familyName ,String email, String phone, String org);
    int registerToProject(String userName, List<String> ids, String leaderId,Integer projectCode);


    boolean registerObserverToProjct(String uid,int projectCode,boolean phone,boolean email);
    boolean setProjectStatus(STATUS status, Integer projectCode);

}
