package Logic.Website;

public class DesignDecorator extends WebsiteDecorator {
    private String designType;
    public DesignDecorator(String deisgnType, WebsiteComponent component) {
        super(component);
        this.designType=deisgnType;
    }

    @Override
    public String buildSite() {
        return super.buildSite() + "\n" + "Design type : " + designType;
    }
}
