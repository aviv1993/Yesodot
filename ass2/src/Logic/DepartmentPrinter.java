package Logic;

import Logic.Entities.Project;

public class DepartmentPrinter implements Observer {
    String departmentName;
    public DepartmentPrinter(String name){
        this.departmentName=name;
    }
    @Override
    public void update(Project project) {
        System.out.println("Department : " + departmentName + " Updates that project : " + project.getName() + " With descirption : " + project.getDesc() + "" +
                " Which was offerd by : " + project.getOffer().getFirstName() + " was approved, uml link : " +  "www.bgu.ac.il/project/uml/" + project.getProjectCode());
    }
}
