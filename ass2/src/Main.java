import DB.ProjectDbImplement;
import DB.UserDbImplement;
import Logic.DepartmentPrinter;
import Logic.Entities.Project;
import Logic.Entities.STATUS;
import Logic.ProjectManager;
import Logic.ProjectManagment;
import Logic.Website.BasicWebsite;
import Logic.Website.WebsiteComponent;

public class Main {

    public static void main(String[] args){
        ProjectManagment pm = new ProjectManager(new UserDbImplement(),new ProjectDbImplement(),new DepartmentPrinter("CS"));
        BasicWebsite website = pm.getBasicWebsite("1","this is basic");
        website.buildSite();
        System.out.println();
        WebsiteComponent wc1= pm.decorateSite("logo","site very good",website,true);
        wc1 = pm.decorateSite("Music","Ariana",wc1,false);
        wc1 = pm.decorateSite("liNK","hhttttpp",wc1,true);
        wc1.buildSite();

    }

}
