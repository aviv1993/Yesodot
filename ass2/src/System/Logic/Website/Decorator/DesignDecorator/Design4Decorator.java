package System.Logic.Website.Decorator.DesignDecorator;

import System.Logic.Website.WebsiteComponent;

public class Design4Decorator extends DesignDecorator {
    public Design4Decorator(String designInformation, WebsiteComponent component){
        super("4, information : " +designInformation, component);
    }
}
