package bridgeProject;

import DB.ProjectDbImplement;
import DB.UserDbImplement;
import Logic.DepartmentPrinter;
import Logic.Entities.STATUS;
import Logic.ProjectManager;
import Logic.ProjectManagment;
import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;

public class RealProxy implements BridgeProject{

    private ProjectManagment system = new ProjectManager(new UserDbImplement(),new ProjectDbImplement(), new DepartmentPrinter("CS"));

    @Override
    public void registerNewTechnicalAdviser(String user, String password) {
        system.register(user,password,false);
    }

    @Override
    public void addNewStudent(String user, String password) {
        system.register(user,password,true);
    }

    @Override
    public int addNewProject(String user, String pass, DBSuggestedProjectInfo suggestedProject) {
        if(system.login(user,pass)){
            int res=system.addProject(user,suggestedProject.projectName,suggestedProject.description,suggestedProject.numberOfHours+"",suggestedProject.firstName,suggestedProject.lastName, suggestedProject.email,suggestedProject.phone,suggestedProject.organization);
            system.setProjectStatus(STATUS.Confirmed,res);
            system.logout(user);
            return res;
        }
        return 0;
    }

    @Override
    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        if(system.login(user,pass)){
            int res = system.registerToProject(user,registeredProject.studentList,registeredProject.academicAdviser,registeredProject.projectId);
            system.logout(user);
            return res;
        }
        return 0;
    }
}
