package Logic.Website.ElementsDecorator;

import Logic.Website.WebsiteComponent;
import Logic.Website.WebsiteDecorator;

public abstract class ElementDecorator extends WebsiteDecorator {

    public ElementDecorator(WebsiteComponent component) {
        super(component);
    }

    public String buildSite() {
        return super.buildSite();
    }
}
