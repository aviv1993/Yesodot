package Logic.Website;

public class ProxyWebsite implements WebsiteComponent {
    boolean allowed;
    WebsiteComponent realComponent;
    public ProxyWebsite(boolean acssesible,WebsiteComponent realComponent) {
        this.allowed = acssesible;
        this.realComponent=realComponent;
    }

    @Override
    public void buildSite() {
        if(allowed)
            realComponent.buildSite();
        else
            System.out.println("This feature is limited");
    }
}
