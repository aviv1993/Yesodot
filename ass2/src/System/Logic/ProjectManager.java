package System.Logic;

import System.DB.ProjectController;
import System.DB.UsersController;

import System.Logic.Entities.Project;
import System.Logic.Entities.STATUS;
import System.Logic.Entities.User;
import System.Logic.Website.*;
import System.Logic.Website.Decorator.DesignDecorator.*;
import System.Logic.Website.Decorator.MenuDecorator;
import System.Logic.Website.Decorator.ElementsDecorator.LinkElementDecorator;
import System.Logic.Website.Decorator.ElementsDecorator.LogoElementDecorator;
import System.Logic.Website.Decorator.ElementsDecorator.MusicElementDecorator;

import java.util.*;

public class ProjectManager implements ProjectManagment {
    Set<User> loggedIn;
    Map<String,WebsiteComponent> map ;
    ProjectController pc;
    UsersController uc;

    DepartmentPrinter dp;

    public ProjectManager(UsersController uc, ProjectController pc, DepartmentPrinter dp) {
        this.uc=uc;
        this.pc=pc;
        this.dp=dp;
        loggedIn=new HashSet<>();
        map=new HashMap<>();
    }

    @Override
    public boolean login(String userName, String pass) {
        if(uc.isValidUser(userName,pass)) {
            loggedIn.add(uc.getUser(userName));
            return true;
        }
        return false;
    }

    @Override
    public boolean logout(String userName) {
        if(loggedIn.contains(userName)){
            loggedIn.remove(uc.getUser(userName));
            return true;
        }
        return false;
    }

    @Override
    public boolean register(String userName, String pass,boolean isStudent) {
        if(!uc.isValidUser(userName,pass)){
            uc.addUser(new User(userName,pass));
            uc.getUser(userName).setIsStudent(isStudent);
            return true;
        }
        return false;
    }

    @Override
    public int addProject(String userName,String name, String description, String howLong, String firstName, String familyName, String email, String phone, String org) {
        User offerUser = uc.getUser(userName);
        if(!validProjectFields(name,description,firstName,howLong,familyName,email,phone)){
            return 0;
        }
        //validating that user is logged in, and that user is technical adviser :
        if(!loggedIn.contains(offerUser) || offerUser.isStudent())
            return 0;
        //validating that time is correct :
        if(Integer.parseInt(howLong) <200 | Integer.parseInt(howLong) > 300)
            return 0;
        //Making sure that the offer user havent already offerd a project this year
        if(isAlreadyOfferdThisYear(org,userName,name))
            return 0;
        offerUser.setUserDetails(firstName,familyName,email,phone);
        uc.setUSerDetails(offerUser);
        Project project = new Project(name,description,org,new Date(),Integer.parseInt(howLong),offerUser,pc.getNextProjectCode());
        pc.addProject(project);
        //registering the department message system to the project :
        project.attach(dp);
        return project.getProjectCode();
    }

    @Override
    public int registerToProject(String userName, List<String> ids, String leaderName,Integer projectCode) {
        User activeUser = uc.getUser(userName);
        Project project= pc.getProject(projectCode);
        if(ids==null || ids.size()<2)
            return 0;
        if(!loggedIn.contains(activeUser) || !uc.isStudent(activeUser.getUid()))
            return 0;
        if(project==null || project.isTaken())
            return 0;
        if(project.getAcademicLeaderName()!=null && project.getAcademicLeaderName().equals(leaderName))
            return 0;
        if(!validProjectField(leaderName))
            return 0;
        if(project.getSTATUS()!=STATUS.Confirmed)
            return 0;
        pc.registerToProject(ids,leaderName,project);
        return projectCode;
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

    @Override
    public void addBasicWebsiteToProject(int projectCode, String text){
        if(pc.getProject(projectCode)!=null)
            map.put(projectCode+"",new BasicWebsite(projectCode+"",text));
    }

    @Override
    public void decorateSite(String featureWanted,String data,int projectId){
        WebsiteComponent component=map.get(projectId+"");
        WebsiteComponent newComponent=null;
        switch(featureWanted.toLowerCase()){
            case "design1" :
                newComponent=new Design1Decorator(data,component);
                break;
            case "design2" :
                newComponent=new Design2Decorator(data,component);
                break;
            case "design3" :
                newComponent=new Design3Decorator(data,component);
                break;
            case "design4" :
                newComponent=new Design4Decorator(data,component);
                break;
            case "menu" :
                newComponent = new MenuDecorator(data,component);
                break;
            case "logo":
                newComponent=new LogoElementDecorator(data,component);
                break;
            case "link":
                newComponent=new LinkElementDecorator(data,component);
                break;
            case "music":
                newComponent=new MusicElementDecorator(data,component);
                break;
            default:
                System.out.println("Wrong decorator feature, please choose from : design , menu, logo, link, music" );
        }
        map.put(projectId+"",newComponent);
    }

    @Override
    public void restrictUsers(List<String> restricedUsers, int projectCode) {
        WebsiteComponent website = map.get(projectCode+"");
        if(website!=null){
            map.put(projectCode+"",new ProxyWebsite(restricedUsers,website));
        }
    }


    @Override
    public WebsiteComponent getWebsite(String userId,int projectCode) {
        WebsiteComponent web = map.get(projectCode+"");
        if(web!=null)
            web.authenticate(userId);
        return web;
    }

    private boolean isAlreadyOfferdThisYear(String org, String userName, String projectName){
        Date date = new Date();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(date);
        int currYear = cal.get(Calendar.YEAR);
        Collection<Project> projects = pc.getAllProjects();
        boolean checkOrg = org!=null && !org.equals("");
        for(Project project : projects){
            cal.setTime(project.getCreateDate());
            int otherYear = cal.get(Calendar.YEAR);
            if(otherYear==currYear && project.getName().equals(projectName)){
                if(project.getOffer().getUid().equals(userName))
                    return true;
                if(checkOrg && project.getOrg().equals(org))
                    return true;
            }
        }
        return false;
    }

    private boolean validProjectFields(String name,String description,String firstName,String howLong,String familyName,String email,String phone){
        boolean res = validProjectField(name) &
        validProjectField(description) &
        validProjectField(firstName) &
        validProjectField(familyName) &
        validProjectField(howLong) &
        validProjectField(familyName) &
        validProjectField(email) &
        validProjectField(phone);
        return res;

    }
    private boolean validProjectField(String field){
        if(field==null || field.equals(""))
            return false;
        return true;
    }


}
