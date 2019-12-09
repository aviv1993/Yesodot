package Logic;

import DB.ProjectController;
import DB.UsersController;
import Logic.Entities.Factory;
import Logic.Entities.Project;
import Logic.Entities.User;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjectManager implements ProjectManagment {
    Set<String> loggedIn;
    ProjectController pc;
    UsersController uc;
    Factory factory;

    public ProjectManager() {
        factory = new Factory();
    }

    @Override
    public boolean login(String userId) {
        if(uc.isValidUser(userId)) {
            loggedIn.add(userId);
            return true;
        }
        return false;
    }

    @Override
    public boolean logout(String userId) {
        if(loggedIn.contains(userId)){
            loggedIn.remove(userId);
            return true;
        }
        return false;
    }

    @Override
    public boolean register(String userId) {
        if(!uc.isValidUser(userId)){
            uc.addUser(factory.makeUser(userId));
            return true;
        }
        return false;
    }

    @Override
    public boolean addProject(String name, String description, String howLong, String firstName, String familyName, String email, String phone, String org) {
        User offerUser = uc.getUser(null);
        if(!loggedIn.contains(offerUser))
            return false;
        if(Integer.parseInt(howLong) <200 | Integer.parseInt(howLong) > 300)
            return false;
        if(pc.isAlreadyOfferThisYear(offerUser.getUid()))
            return false;
        offerUser.setUserDetails(firstName,familyName,email,phone);
        uc.setUSerDetails(offerUser);
        pc.addProject(Factory.makeProject(name,description,org,new Date(),Integer.parseInt(howLong),offerUser,pc.getNextProjectCode()));
        return true;
    }

    @Override
    public boolean registerToProject(List<String> ids, String leaderId,Integer projectCode) {
        User activeUser = uc.getUser(null),leader = uc.getUser(leaderId);
        Project project= pc.getProject(projectCode);
        if(ids.size()<2)
            return false;
        if(!loggedIn.contains(activeUser) || uc.isStudent(activeUser.getUid()))
            return false;
        if(project==null || project.isTaken())
            return false;
        if(project.getLeader()!=null && leader!=null && !project.getLeader().getFirstName().equals(leader.getFirstName()))
            return false;
        pc.registerToProject(ids,leader,project);
        return true;
    }
}
