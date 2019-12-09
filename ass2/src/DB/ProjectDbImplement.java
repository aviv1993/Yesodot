package DB;

import Logic.Entities.Project;
import Logic.Entities.User;

import java.util.*;

public class ProjectDbImplement implements ProjectController{
    private Integer projectCode;
    private Map<Integer,Project> projects;

    public ProjectDbImplement(){
        projectCode=0;
        projects=new HashMap<>();
    }
    @Override
    public boolean addProject(Project project) {
        projects.put(project.getProjectCode(),project);
        return false;
    }

    @Override
    public Project getProject(Integer projectCode) {
        return projects.get(projectCode);
    }

    @Override
    public Integer getNextProjectCode() {
        int tmp = projectCode.intValue();
        projectCode++;
        return tmp;
    }

    @Override
    public boolean isAlreadyOfferThisYear(String userid) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(date);
        int currYear = cal.get(Calendar.YEAR);
        for(Project pr : projects.values()){
            if(pr.getOffer().getUid().equals(userid)) {
                Date otherDate = pr.getCreateDate();
                cal.setTime(date);
                int otherYear = cal.get(Calendar.YEAR);
                if(otherYear==currYear)
                    return false;
            }
        }
        return true;
    }

    @Override
    public boolean registerToProject(List<String> ids, User leader, Project project) {
        project.setLeader(leader);
        return false;
    }
}
