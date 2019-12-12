package Logic.Website;

public class DesignDecorator extends WebsiteDecorator {
    private String designType;
    public DesignDecorator(String deisgnType, WebsiteComponent component) {
        super(component);
        this.designType=deisgnType;
    }

    @Override
    public void buildSite() {
        super.buildSite();
        System.out.println("Design type : " + designType);
    }
}
