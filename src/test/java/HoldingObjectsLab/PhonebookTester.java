package HoldingObjectsLab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by evanhitchings on 9/29/16.
 */
public class PhonebookTester {

    Phonebook pb = new Phonebook();
    ArrayList<String> jennyNumbers = new ArrayList<String>();
    ArrayList<String> mrNumbers = new ArrayList<String>();

    @Before
    public void setup(){
        jennyNumbers.add("302-867-5309");
        mrNumbers.add("302-555-5555");
        pb.getBook().put("Jenny", jennyNumbers);
    }



    @Test
    public void lookupTest(){

        Assert.assertEquals("Lookup by name did not return the correct number", "302-867-5309", pb.lookup("Jenny").get(0));

    }

    @Test
    public void addTest(){
        pb.add("Mr Jane Doe", "302-555-5555");
        Assert.assertEquals("Add method did not actually add", mrNumbers, pb.getBook().get("Mr Jane Doe"));
        pb.add("Mr Jane Doe", "302-123-4567");
        Assert.assertTrue("Did not add additional number", pb.lookup("Mr Jane Doe").contains("302-123-4567"));


    }

    @Test
    public void removeNumberTest(){
        pb.add("Mr Jane Doe", "302-555-5555");
        pb.add("Mr Jane Doe", "302-123-4567");
        pb.removeNumber("Mr Jane Doe", "302-123-4567");
        Assert.assertFalse("Remove number did not remove number", pb.lookup("Mr Jane Doe").contains("302-123-4567"));
    }

    @Test
    public void removeRecordTest(){
        pb.removeRecord("Jenny");
        Assert.assertFalse("Remove method did not actually remove", pb.getBook().containsKey("Jenny"));
    }

    @Test
    public void reverseLookupTest(){
        pb.add("Jenny", "302-867-5309");
        Assert.assertEquals("Reverse Lookup did not return correct name", "Jenny", pb.reverseLookup("302-867-5309"));
    }






}
