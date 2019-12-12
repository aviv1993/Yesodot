package Logic.Website.ElementsDecorator;

import Logic.Website.WebsiteComponent;

public class LogoElementDecorator extends ElementDecorator {
    private String logo;
    public LogoElementDecorator(String logo, WebsiteComponent component) {
        super(component);
        this.logo=logo;
    }

    @Override
    public void buildSite(){
        super.buildSite();
        System.out.println("Logo : " +  logo);
    }
}
