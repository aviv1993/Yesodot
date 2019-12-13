package Logic.Website.ElementsDecorator;

import Logic.Website.WebsiteComponent;

public class MusicElementDecorator extends ElementDecorator {
    private String music;
    public MusicElementDecorator(String music, WebsiteComponent component) {
        super(component);
        this.music=music;
    }

    @Override
    public String buildSite(){
        return super.buildSite() + "\n" + "Playing music : " + music;
    }
}
