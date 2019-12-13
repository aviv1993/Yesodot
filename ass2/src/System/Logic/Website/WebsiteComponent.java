package System.Logic.Website;

public interface WebsiteComponent {
    String buildSite();
    void authenticate(String userId);
}
