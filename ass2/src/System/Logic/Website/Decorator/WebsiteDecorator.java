package System.Logic.Website.Decorator;

import System.Logic.Website.WebsiteComponent;

public abstract class WebsiteDecorator implements WebsiteComponent {
    private WebsiteComponent component;

    public WebsiteDecorator(WebsiteComponent component) {
        this.component = component;
    }

    @Override
    public String buildSite() {
        return component.buildSite();
    }

    @Override
    public void authenticate(String userId) {
        component.authenticate(userId);
    }
}
