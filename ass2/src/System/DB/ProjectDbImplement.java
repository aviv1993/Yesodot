package System.DB;

import System.Logic.Entities.Project;
//import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.*;

public class ProjectDbImplement implements ProjectController{
    private Integer projectCode;
    private Map<Integer,Project> projects;

    public ProjectDbImplement(){
        projectCode=1;
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
    public boolean registerToProject(List<String> ids, String leader, Project project) {
        project.setAcademicLeaderName(leader);
        project.setStudents(ids);
        return false;
    }

    @Override
    public Collection<Project> getAllProjects(){
        return  projects.values();
    }

}
