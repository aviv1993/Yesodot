package System.Logic.Website.Decorator.DesignDecorator;

import System.Logic.Website.WebsiteComponent;

public class Design2Decorator extends DesignDecorator {
    public Design2Decorator(String designInformation, WebsiteComponent component){
        super("2, information : " +designInformation, component);
    }
}
