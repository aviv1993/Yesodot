package Logic.Website;

public class MenuDecorator extends WebsiteDecorator {
    private String menu;
    public MenuDecorator(String menu, WebsiteComponent component) {
        super(component);
        this.menu=menu;
    }

    @Override
    public String buildSite(){
        return super.buildSite() + "\nMenu : " + menu;
    }
}
