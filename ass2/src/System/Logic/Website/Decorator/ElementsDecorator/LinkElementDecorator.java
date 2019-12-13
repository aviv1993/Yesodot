package System.Logic.Website.Decorator.ElementsDecorator;

import System.Logic.Website.WebsiteComponent;

public class LinkElementDecorator extends ElementDecorator {
    private String link;
    public LinkElementDecorator(String link, WebsiteComponent component) {
        super(component);
        this.link=link;
    }

    @Override
    public String buildSite(){
        return super.buildSite() + "\n" + "Link: " + link;
    }
}
