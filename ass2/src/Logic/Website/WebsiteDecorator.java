package Logic.Website;

public abstract class WebsiteDecorator implements WebsiteComponent {
    private WebsiteComponent component;

    public WebsiteDecorator(WebsiteComponent component) {
        this.component = component;
    }

    @Override
    public void buildSite() {
        component.buildSite();
    }
}
