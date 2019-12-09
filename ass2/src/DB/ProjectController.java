package DB;

import Logic.Entities.Project;
import Logic.Entities.User;

import java.util.List;

public interface ProjectController {
    boolean addProject(Project project);
    Project getProject(Integer projectCode);
    Integer getNextProjectCode();
    boolean isAlreadyOfferThisYear(String userid);
    boolean registerToProject(List<String> ids, User leader, Project project);
}
