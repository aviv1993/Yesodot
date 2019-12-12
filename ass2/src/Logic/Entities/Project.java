package Logic.Entities;

import Logic.Observer;
import Logic.Subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project implements Subject {
    private String name,desc,org;
    private int howLong;
    private User offer;
    private String academicLeaderName;
    private List<String> students;
    private boolean isTaken;
    private Integer projectCode;
    private STATUS status;
    private Date createDate;
    private List<Observer> observers;

    public Project(String name, String desc, String org, Date createDate, int howLong, User offer,Integer projectCode) {
        this.name = name;
        this.desc = desc;
        this.org = org;
        this.createDate = createDate;
        this.howLong = howLong;
        this.offer = offer;
        this.projectCode = projectCode;
        this.status = STATUS.Check;
        observers=new ArrayList<>();
        students=null;
    }

    public String getAcademicLeaderName() {
        return academicLeaderName;
    }

    public void setAcademicLeaderName(String academicLeaderName) {
        this.academicLeaderName = academicLeaderName;
    }

    public Integer getProjectCode(){
        return projectCode;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public User getOffer() {
        return offer;
    }

    public String getName() {
        return name;
    }

    public void setStatus(STATUS status) {
        this.status = status;
        if(status==STATUS.Confirmed)
            notifyObservers();
    }

    public String getDesc() {
        return desc;
    }

    public String getOrg() {
        return org;
    }

    @Override
    public void attach(Observer user) {
        observers.add(user);
    }

    @Override
    public void deattach(Observer user) {
        observers.remove(user);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers)
            observer.update(this);
    }

    public STATUS getSTATUS(){
        return status;
    }
}
