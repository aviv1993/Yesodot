package System.Logic.Website.Decorator.ElementsDecorator;

import System.Logic.Website.WebsiteComponent;
import System.Logic.Website.Decorator.WebsiteDecorator;

public abstract class ElementDecorator extends WebsiteDecorator {

    public ElementDecorator(WebsiteComponent component) {
        super(component);
    }

    public String buildSite() {
        return super.buildSite();
    }
}
