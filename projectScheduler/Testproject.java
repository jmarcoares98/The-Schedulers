package projectScheduler;

 

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

 

public class Testproject {

 

       Project spyProject = spy(new Project("halloween", "party"));

 

       @Test

       public void testFormatProject() {

             String actual = spyProject.formatProject(1);

             String expected = "(1) halloween: party";

             assertEquals(actual, expected);

       }

 

}