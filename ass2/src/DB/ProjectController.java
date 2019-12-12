package DB;

import Logic.Entities.Project;
import Logic.Entities.User;

import java.util.Collection;
import java.util.List;

public interface ProjectController {
    boolean addProject(Project project);
    Project getProject(Integer projectCode);
    Integer getNextProjectCode();
    boolean registerToProject(List<String> ids, String leader, Project project);
    Collection<Project> getAllProjects();
}
