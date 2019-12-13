package System.Logic.Website.Decorator.DesignDecorator;

import System.Logic.Website.Decorator.WebsiteDecorator;
import System.Logic.Website.WebsiteComponent;

public abstract class DesignDecorator extends WebsiteDecorator {
    private String designType;
    public DesignDecorator(String designInformation,WebsiteComponent component) {
        super(component);
        this.designType=designInformation;
    }

    @Override
    public String buildSite() {
        return super.buildSite() + "\n" + "Design type : " + designType;
    }
}
