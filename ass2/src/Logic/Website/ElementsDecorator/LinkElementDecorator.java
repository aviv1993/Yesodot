package Logic.Website.ElementsDecorator;

import Logic.Website.WebsiteComponent;

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
