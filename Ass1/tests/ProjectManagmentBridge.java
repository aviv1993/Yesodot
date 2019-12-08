import java.util.List;

public interface ProjectManagmentBridge {
    boolean addProject(String projectName, String decription, int time, String firstName, String lastName, String mail, String phone,  String org);
    boolean RegisterToProject(String[] ids, String leader);
}
