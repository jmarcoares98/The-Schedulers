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

 
   		@Test 
   		public void Integrate_Project_With_Event() {
   			Project p1 = spy(new Project("Cpts 422","Software Engineering Principles II")); 
   			if ("Cpts 422"==p1.getName()){
   				Event se = spy(new Event("422 Exam", "2020-11-29", "2020-11-30", "Unit and Integration testing", "Cpts 422"));
   				p1.Events.add(se);
   				assertEquals("422 Exam",p1.Events.get(0).getName());
   				assertEquals(LocalDate.parse("2020-11-29"),p1.Events.get(0).getStartDate());
   				assertEquals(LocalDate.parse("2020-11-30"),p1.Events.get(0).getEndDate());
   				assertEquals("Unit and Integration testing",p1.Events.get(0).getDescription());
   				assertEquals("Cpts 422",p1.Events.get(0).getProjectname());
   				
   			}
   			else {
				assertEquals(1,2);
			}
   		}
       
       
       

}