import System.DB.ProjectDbImplement;
import System.DB.UserDbImplement;
import System.Logic.DepartmentPrinter;
import System.Logic.ProjectManager;
import System.Logic.ProjectManagment;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        ProjectManagment pm = new ProjectManager(new UserDbImplement(),new ProjectDbImplement(),new DepartmentPrinter("CS"));
        pm.register("avi","avi",false);
        pm.login("avi","avi");
        List<String> restricted = new ArrayList<>();
        restricted.add("meme");
        int code = pm.addProject("avi","asd","asd","201","asd","asd","asd","asd","asd");

        pm.addBasicWebsiteToProject(code,"BASE TO THE BASE");
        pm.restrictUsers(restricted,code);
        pm.decorateSite("design1","LOGOGOGOGOGOGOGOGG",code);
        pm.decorateSite("design2","menu 1 2 34",code);
        pm.decorateSite("design3","fafa.mp3",code);
        pm.decorateSite("design4","https://",code);
        pm.decorateSite("logo","DESIGN 5",code);
        pm.restrictUsers(restricted,code);

        System.out.println(pm.getWebsite("meme",code).buildSite());
        //pm;
    }

}
