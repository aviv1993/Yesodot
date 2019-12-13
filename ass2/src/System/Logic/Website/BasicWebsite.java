package System.Logic.Website;

public class BasicWebsite implements WebsiteComponent {
   String text;
   String projectCode;
   String connectedUser;

    public BasicWebsite(String projectCode, String text) {
        this.text = text;
        this.projectCode=projectCode;
    }

    @Override
    public String buildSite() {
        return "Project code number : " + projectCode +", Has this website :" + "\n" +"Text : " + text;
    }

    @Override
    public void authenticate(String userId) {
        connectedUser=userId;
    }
}
