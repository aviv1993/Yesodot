import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddAndRegisterProjectTest extends ProjectManagmentTests {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    /*
    Add project Tests :
    */

    @Test
    public void testAddProject(){
       assertTrue(addProject("Havivi","This is a cool project",5,"GG","Hadid","A@A.com","1234","google?"));
       assertTrue(addProject("Another One","This is another project",5,"Kim","Kard","K@K.com","1234","microsft?"));
    }

    @Test
    public void testAddProjectHiddenAssumptions(){
        assertTrue(addProject("Project x","",5,"KK","PP","K@K.com","1234","microsfti?")); //description is empty
        assertFalse(addProject("פרוג׳ט איקס","",5,"KK","PP","K@K.com","1234","microsfti?")); //description is empty
    }
    @Test
    public void testAddProjectInvalidInput(){
        assertFalse(addProject("ggg","i have no time",-5,"BB","Netan","B@B.com","12345","google?")); // invalid time
        assertFalse(addProject("","This project name is the empty string",5,"Yahir","LApid","Y@Y.com","12321","facebook?")); // empty project name
        assertFalse(addProject("name","i have no name",5,"","LApid","Y@Y.com","12321","facebook?")); // empty offer preson name
        assertFalse(addProject("Havivi","dec",52,"Av","LApid","Y@Y.com","12321","facebook?")); // Project name is already taken
    }


    /*
    Registration Tests :
    */

    @Test
    public void testRegisterToProject(){
        String[] ids1 = {"33","44","55","66"};
        String[] ids2 = {"77","88","99"};
        assertTrue(registerToProject(ids1,"Shimon"));
        assertTrue(registerToProject(ids2,"Moshe"));
    }
    @Test
    public void testRegisterTOProjectInvalidInput() {
        String[] ids1 = {"12"};
        String[] ids2 = {"123b"};
        String[] ids3 = {"34"};
        assertFalse(registerToProject(ids1, "Timor")); //id 12 does not belong to a student
        assertFalse(registerToProject(ids2, "Chiko"));//Illegal id
        assertFalse(registerToProject(ids3, "Fiko")); //Fiko does not show in the system DB
    }

    @Test
    public void testRegistrationHiddenAssumptions(){
        String[] ids1 = {"56"};
        String[] ids2 = {"78"};
        assertFalse(registerToProject(ids1,"Pini"));//assume 56 is a third year student
        assertFalse(registerToProject(ids2,"Tiki")); //assume id 78 is already assigned to a project
    }
    

}
