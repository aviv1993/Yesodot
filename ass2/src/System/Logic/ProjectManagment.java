package System.Logic;

import System.Logic.Entities.STATUS;
import System.Logic.Website.WebsiteComponent;

import java.util.List;

public interface ProjectManagment {

    //basic functions :
    boolean login(String name, String pass);
    boolean logout(String name);
    boolean register(String name,String pass,boolean isStudent);

    //user stories, question 1 :
    int addProject(String userName, String name ,String description ,String howLong ,String firstName ,String familyName ,String email, String phone, String org);
    int registerToProject(String userName, List<String> ids, String leaderId,Integer projectCode);

    //observer pattern, question 3 :
    boolean registerObserverToProjct(String uid,int projectCode,boolean phone,boolean email);
    boolean setProjectStatus(STATUS status, Integer projectCode);

    //decorator+proxy patterns, question 4 :

    void addBasicWebsiteToProject(int projectCode, String text);
    void decorateSite(String featureWanted, String data, int projectId);
    void restrictUsers(List<String> restricedUsers,int projectCode);
    WebsiteComponent getWebsite(String userId,int projectCode);

}
