package Logic.Entities;

import Logic.Observer;
import Logic.Subject;

public class User implements Observer {
    private String uid, firstName, familyName, mail, phoneNumber;
    private boolean isStudent;
    private boolean notifyPhone,notifyEmail;
    public User(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public void setUserDetails(String firstName,String familyName, String email,String phoneNumber){
        setFamilyName(familyName);
        setFirstName(firstName);
        setMail(email);
        setPhoneNumber(phoneNumber);
    }

    public String getUid(){
        return uid;
    }

    public boolean isNotifyPhone() {
        return notifyPhone;
    }

    public void setNotifyPhone(boolean notifyPhone) {
        this.notifyPhone = notifyPhone;
    }

    public boolean isNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(boolean notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    @Override
    public void update(Project project) {
        if(isNotifyEmail()){
            System.out.println("Sending to mail : " + getMail() +": " +"Project name :" + project.getName() + "Got approved, url : " + "www.bgu.ac.il/project/" + project.getProjectCode());
        }
        if(isNotifyPhone()){
            System.out.println("Sending to phone : " + getPhoneNumber() +": " +"Project name :" + project.getName() + "Got approved, url : " + "www.bgu.ac.il/project/" + project.getProjectCode());
        }
    }
}

