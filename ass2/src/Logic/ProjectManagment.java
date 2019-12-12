package Logic;

import Logic.Entities.Project;
import Logic.Entities.STATUS;
import Logic.Website.BasicWebsite;
import Logic.Website.WebsiteComponent;

import java.util.List;

public interface ProjectManagment {

    //basic functions :
    boolean login(String name, String pass);
    boolean logout(String name);
    boolean register(String name,String pass,boolean isStudent);

    //user stories, question 1 :
    int addProject(String userName, String name ,String description ,String howLong ,String firstName ,String familyName ,String email, String phone, String org);
    int registerToProject(String userName, List<String> ids, String leaderId,Integer projectCode);

    //observer pattern, question 2 :
    boolean registerObserverToProjct(String uid,int projectCode,boolean phone,boolean email);
    boolean setProjectStatus(STATUS status, Integer projectCode);

    //decorator+proxy patterns, question 3 :
    BasicWebsite getBasicWebsite(String projectCode, String text);
    WebsiteComponent decorateSite(String featureWanted, String data, WebsiteComponent component, boolean accessible);

}
