package System.Logic.Website.Decorator.DesignDecorator;

import System.Logic.Website.WebsiteComponent;

public class Design1Decorator extends DesignDecorator {
    public Design1Decorator(String designInformation, WebsiteComponent component){
        super("1, information : " +designInformation, component);
    }
}
