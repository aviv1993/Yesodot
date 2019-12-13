package System.Logic.Website.Decorator.ElementsDecorator;

import System.Logic.Website.WebsiteComponent;

public class LogoElementDecorator extends ElementDecorator {
    private String logo;
    public LogoElementDecorator(String logo, WebsiteComponent component) {
        super(component);
        this.logo=logo;
    }

    @Override
    public String buildSite(){
        return super.buildSite() + "\n" + "Logo : " +  logo;
    }
}
