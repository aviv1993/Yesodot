package Logic.Website;

public class ProxyWebsite implements WebsiteComponent {
    boolean allowed;
    WebsiteComponent realComponent;
    public ProxyWebsite(boolean acssesible,WebsiteComponent realComponent) {
        this.allowed = acssesible;
        this.realComponent=realComponent;
    }

    @Override
    public String buildSite() {
        String out;
        if(allowed)
            out = realComponent.buildSite();
        else
            out = "This feature is limited to you";
        return out;

    }
}
