package Logic.Website;

import java.sql.SQLOutput;

public class BasicWebsite implements WebsiteComponent {
   String text;
   String projectCode;

    public BasicWebsite(String projectCode, String text) {
        this.text = text;
        this.projectCode=projectCode;
    }

    @Override
    public void buildSite() {
        System.out.println("Project code number : " + projectCode +", Has this website :");
        System.out.println("Text : " + text);
    }
}
