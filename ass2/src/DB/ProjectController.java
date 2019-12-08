package DB;

import Logic.Entities.Project;

import java.util.List;

public interface ProjectController {
    boolean addProject(Project project);
    Project getProject(String projectCode);
    String getNextProjectCode();
    boolean isAlreadyOfferThisYear(String userid);
    boolean registerToProject(List<String> ids,String leader);
}
