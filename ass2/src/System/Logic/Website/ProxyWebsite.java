package System.Logic.Website;

import java.util.List;

public class ProxyWebsite implements WebsiteComponent {
    private WebsiteComponent realComponent;
    private String connectdUser;
    private List<String> restriectedUsers;
    public ProxyWebsite(List<String> restriectedUsers, WebsiteComponent realComponent) {
        this.realComponent=realComponent;
        this.restriectedUsers=restriectedUsers;
    }

    @Override
    public String buildSite() {
        String out = realComponent.buildSite();
        if(connectdUser!=null && restriectedUsers.contains(connectdUser)) {
            out=out.substring(0, out.lastIndexOf('\n'));
            out+= "\n!!!!!!!!!!!!!!!!!!! This feature has been restricted to you !!!!!!!!!!!!!!!!!!!";
        }
        return out;
    }

    @Override
    public void authenticate(String userId) {
        this.connectdUser=userId;
        realComponent.authenticate(userId);
    }

}
