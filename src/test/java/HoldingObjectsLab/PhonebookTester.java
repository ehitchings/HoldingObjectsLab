package HoldingObjectsLab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by evanhitchings on 9/29/16.
 */
public class PhonebookTester {

    Phonebook pb = new Phonebook();

    @Before
    public void setup(){
        pb.getBook().put("Jenny", "302-867-5309");
    }



    @Test
    public void lookupTest(){
        Assert.assertEquals("Lookup by name did not return the correct number", "302-867-5309", pb.lookup("Jenny"));

    }

    @Test
    public void addTest(){
        pb.add("Mr Jane Doe", "302-555-5555");
        Assert.assertEquals("Add method did not actually add", "302-555-5555", pb.getBook().get("Mr Jane Doe"));

    }

    @Test
    public void removeTest(){
        pb.remove("Jenny");
        Assert.assertFalse("Remove method did not actually remove", pb.getBook().containsKey("Jenny"));
    }




}
