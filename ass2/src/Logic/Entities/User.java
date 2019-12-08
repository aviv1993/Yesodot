package Logic.Entities;

public class User {
    private String uid, firstName, familyName, mail, phoneNumber;
    private boolean isStudent;

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
}

