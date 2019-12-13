package System.Logic.Website.Decorator.DesignDecorator;

import System.Logic.Website.WebsiteComponent;

public class Design3Decorator  extends DesignDecorator{
    public Design3Decorator(String designInformation, WebsiteComponent component){
        super("3, information : " +designInformation, component);
    }
}
