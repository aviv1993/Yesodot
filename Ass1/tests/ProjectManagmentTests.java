import junit.framework.TestCase;
import org.junit.Before;

public class ProjectManagmentTests {
    ProjectManagmentBridge bridge;
    @Before
    public void setUp() throws Exception {
        bridge=Driver.getBridge();
    }

    public boolean addProject(String projectName, String decription, int time, String firstName, String lastName, String mail, String phone,String org) {
        return bridge.addProject(projectName,decription,time,firstName,lastName,mail,phone,org);
    }

    public boolean registerToProject(String[] ids, String leader) {
        return bridge.RegisterToProject(ids,leader);
    }

}
