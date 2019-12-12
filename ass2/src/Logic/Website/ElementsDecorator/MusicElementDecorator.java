package Logic.Website.ElementsDecorator;

import Logic.Website.WebsiteComponent;

public class MusicElementDecorator extends ElementDecorator {
    private String designType;
    public MusicElementDecorator(String designeType, WebsiteComponent component) {
        super(component);
        this.designType=designeType;
    }

    @Override
    public void buildSite(){
        super.buildSite();
        System.out.println("Design type is : " + designType);
    }
}
