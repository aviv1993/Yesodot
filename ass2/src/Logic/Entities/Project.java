package Logic.Entities;

import java.util.Date;
import java.util.List;

public class Project {
    private String name,desc,org;
    private int howLong;
    private User offer,leader;
    private List<User> students;
    private boolean isTaken;
    private String projectCode;
    private STATUS status;
    private Date createDate;

    public Project(String name, String desc, String org, Date createDate, int howLong, User offer,String projectCode) {
        this.name = name;
        this.desc = desc;
        this.org = org;
        this.createDate = createDate;
        this.howLong = howLong;
        this.offer = offer;
        this.projectCode = projectCode;
        this.status = STATUS.Check;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public String getProjectCode(){
        return projectCode;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
