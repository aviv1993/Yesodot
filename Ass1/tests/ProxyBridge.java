import java.util.List;

public class ProxyBridge implements ProjectManagmentBridge {
    ProjectManagmentBridge realBridge;

    public void setBridge(ProjectManagmentBridge bridge) {
        this.realBridge = bridge;
    }

    @Override
    public boolean addProject(String projectName, String decription, int time, String firstName,String lastName, String mail, String phone, String org) {
        if(realBridge!=null)
            return realBridge.addProject(projectName,decription,time,firstName,lastName,mail,phone,org);
        return true;
    }

    @Override
    public boolean RegisterToProject(String[] ids, String leader) {
        if(realBridge!=null)
            return realBridge.RegisterToProject(ids,leader);
        return false;
    }

}
