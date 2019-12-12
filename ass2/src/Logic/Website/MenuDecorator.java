package Logic.Website;

public class MenuDecorator extends WebsiteDecorator {
    private String menu;
    public MenuDecorator(String menu, WebsiteComponent component) {
        super(component);
        this.menu=menu;
    }

    @Override
    public void buildSite(){
        super.buildSite();
        System.out.println("Menu : " + menu);
    }
}
