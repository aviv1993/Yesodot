package Logic;

import DB.ProjectController;
import DB.UsersController;
import Logic.Entities.Factory;
import Logic.Entities.Project;
import Logic.Entities.STATUS;
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
    DepartmentPrinter dp;

    public ProjectManager(UsersController uc, ProjectController pc, DepartmentPrinter dp) {
        this.uc=uc;
        this.pc=pc;
        this.dp=dp;
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
        //validating that user is logged in :
        if(!loggedIn.contains(offerUser))
            return false;
        //validating that time is correct :
        if(Integer.parseInt(howLong) <200 | Integer.parseInt(howLong) > 300)
            return false;
        //Making sure that the offer user havent already offerd a project this year
        if(pc.isAlreadyOfferThisYear(offerUser.getUid()))
            return false;
        offerUser.setUserDetails(firstName,familyName,email,phone);
        uc.setUSerDetails(offerUser);
        Project project = Factory.makeProject(name,description,org,new Date(),Integer.parseInt(howLong),offerUser,pc.getNextProjectCode());
        pc.addProject(project);
        //registering the department message system to the project :
        project.attach(dp);
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
    @Override
    public boolean setProjectStatus(STATUS status,Integer projectCode){
        Project project = pc.getProject(projectCode);
        if(project==null)
            return false;
        project.setStatus(status);
        return true;
    }

    @Override
    public boolean registerObserverToProjct(String uid,int projectCode,boolean phone,boolean email){
        User user = uc.getUser(uid);
        Project project = pc.getProject(projectCode);
        if(user==null | project==null)
            return false;
        project.attach(user);
        user.setNotifyPhone(phone);
        user.setNotifyEmail(email);
        return true;
    }
}
