package projectScheduler;

 

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

 

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
       
          
       

       @Test

       public void testFormatProject() {

             String actual = spyProject.formatProject(1);

             String expected = "(1) halloween: party";

             assertEquals(actual, expected);
             
             
             Project sp = spy(new Project()); 
        	 int i = 1;
        	 doReturn("name").when(sp).getName(); 
        	 doReturn("descr").when(sp).getDescription();
        	 assertEquals("(1) name: descr",sp.formatProject(i)); 
             
             

       }

 
   		
       
       
       

}