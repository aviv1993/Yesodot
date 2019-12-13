package System.Logic;

import System.Logic.Entities.Project;

public class DepartmentPrinter implements Observer {
    String departmentName;
    public DepartmentPrinter(String departmentName){
        this.departmentName=departmentName;
    }
    @Override
    public void update(Project project) {
        System.out.println("Department : " + departmentName + " Updates that project : " + project.getName() + " With descirption : " + project.getDesc() + "" +
                " Which was offerd by : " + project.getOffer().getFirstName() + " was approved, uml link : " +  "www.bgu.ac.il/project/uml/" + project.getProjectCode());
    }
}
