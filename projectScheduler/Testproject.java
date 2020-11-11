package projectScheduler;

 

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

 

public class Testproject {

 

       Project spyProject = spy(new Project("halloween", "party"));

 
       @Test
       public void testProject() {
    	Project sp = spy(new Project("name","descr")); 
   		String expName = "name";
   		String expDescr = "descr";
   		assertEquals(expName,sp.getName());
   		assertEquals(expDescr,sp.getDescription());
   		}
       
        //can format member be changed to out = "("+i+")"+" "+this.getname()+": "+this.getemail(); ?? That way can mock both calls
   	   @Test
   	    
   	   public void test_formatProject() {
   	    	
   	    Project sp = spy(new Project("1", "2"));  // don't technically need parameters... maybe just have default constructor added to Project.java?  
   	    int i = 1;
   		doReturn("name").when(sp).getName(); 
   		doReturn("descr").when(sp).getDescription();
   		assertEquals("(1) name: descr",sp.formatProject(i)); 
   	}
       
       
       
       

       @Test

       public void testFormatProject() {

             String actual = spyProject.formatProject(1);

             String expected = "(1) halloween: party";

             assertEquals(actual, expected);

       }

 
       
       
       
       

}