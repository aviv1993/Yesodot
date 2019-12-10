import DB.ProjectController;
import DB.ProjectDbImplement;
import DB.UserDbImplement;
import DB.UsersController;
import Logic.DepartmentPrinter;
import Logic.Entities.Project;
import Logic.ProjectManager;
import Logic.ProjectManagment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    private static ProjectManagment pm;

    public static void main(String[] args){
        initAll();
        /*
        pm.register("")
                */
    }

    public static void initAll(){
        DepartmentPrinter dp1 = new DepartmentPrinter("CS");
        ProjectController pc = new ProjectDbImplement();
        UsersController uc = new UserDbImplement();
        pm = new ProjectManager(uc,pc,dp1);
    }

}
