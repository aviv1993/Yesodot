package System.Logic.Entities;

import System.Logic.Observer;

import java.util.Objects;

public class User implements Observer {
    private String uid, firstName, familyName, mail, phoneNumber;
    private String pass;
    private boolean isStudent;
    private boolean notifyPhone,notifyEmail;
    public User(String uid, String pass) {
        this.uid = uid;
        this.pass=pass;
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
        if(project.getSTATUS()==STATUS.Confirmed){
            if(isNotifyEmail())
                notifyEmail(project.getName(),project.getProjectCode()+"");
            if(isNotifyPhone())
                notifyPhone(project.getName(),project.getProjectCode()+"");

        }
    }

    public boolean isTheSamePAss(String other){
        return other!=null && other.equals(pass);
    }

    public void setIsStudent(boolean is){
        this.isStudent=is;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isStudent == user.isStudent &&
                notifyPhone == user.notifyPhone &&
                notifyEmail == user.notifyEmail &&
                Objects.equals(uid, user.uid) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(familyName, user.familyName) &&
                Objects.equals(mail, user.mail) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(pass, user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, firstName, familyName, mail, phoneNumber, pass, isStudent, notifyPhone, notifyEmail);
    }

    private void notifyEmail(String projectName,String projectCode){
        System.out.println("Sending to user : " + getUid() + ", Via Mail, " +": " +"Project name :" + projectName + " Got approved, url : " + "www.bgu.ac.il/project/" + projectCode);

    }
    private void notifyPhone(String projectName,String projectCode){
        System.out.println("Sending to user : " + getUid() + " Via Phone, " +": " +"Project name :" + projectName + " Got approved, url : " + "www.bgu.ac.il/project/" + projectCode);

    }
}

