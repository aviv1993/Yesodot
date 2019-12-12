import DB.ProjectDbImplement;
import DB.UserDbImplement;
import Logic.DepartmentPrinter;
import Logic.Entities.STATUS;
import Logic.ProjectManager;
import Logic.ProjectManagment;

public class Main {

    public static void main(String[] args){
        ProjectManagment pm = new ProjectManager(new UserDbImplement(),new ProjectDbImplement(),new DepartmentPrinter("CS"));
        //Students :
        pm.register("a","a",true);
        pm.register("b","b",true);
        pm.register("c","c",true);
        pm.register("d","d",true);
       //Offer :
        pm.register("e","e",false);
        //Login :
        pm.login("a","a");
        pm.login("b","b");
        pm.login("c","c");
        pm.login("d","d");
        pm.login("e","e");

        //Add projects :
        int pid = pm.addProject("e","project","AS","220","AS","AS","AS","AS","AS");
         //Register observer :
        pm.registerObserverToProjct("a",pid,true,true);
        pm.setProjectStatus(STATUS.Confirmed,pid);



    }

}
