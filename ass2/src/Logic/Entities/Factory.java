package Logic.Entities;

import java.util.Date;

public class Factory {

    public static User makeUser(String uid){
        return new User(uid);
    }

    public static Project makeProject(String name, String desc, String org, Date createDate, int howLong, User offer,Integer projectCode){
        return new Project(name,desc,org,createDate,howLong,offer,projectCode);
    }
}
