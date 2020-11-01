package projectScheduler;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.time.LocalDate;
import org.junit.Test;

public class Testmain {
	ArrayList<Project> spyPL = spy(new ArrayList<Project>());
	ArrayList<Event> spySL= new ArrayList<Event>();
	Main x = new Main();
	/*
	
	*/
	
	@Test
	public void testorderEvents() {
		//adds new project with 2 members
		spyPL.add(new Project("Pname1", "Pdesc1"));	
		
		//add event
		spyPL.get(0).Events.add(new Event("Ename1", "2020-10-30", "2020-10-31","Edesc1",spyPL.get(0).getName()));
		
		//add event
		spyPL.get(0).Events.add(new Event("Ename2", "2020-11-03", "2020-11-07","Edesc2",spyPL.get(0).getName()));
		
		spySL = x.orderEvents(spyPL);
		
		LocalDate actual =  spySL.get(0).getEndDate();
		LocalDate expected = LocalDate.parse("2020-10-31");
		assertEquals(actual, expected);
		
		actual =  spySL.get(1).getEndDate();
		expected = LocalDate.parse("2020-11-07");
		assertEquals(actual, expected);
		
		//adds new project
		spyPL.add(new Project("Pname2", "Pdesc2"));	
		//add event
		spyPL.get(1).Events.add(new Event("Ename3", "2020-09-13", "2020-09-15","Edesc3",spyPL.get(1).getName()));
		
		spySL = x.orderEvents(spyPL);
		
		actual =  spySL.get(0).getEndDate();
		expected = LocalDate.parse("2020-09-15");
		assertEquals(actual, expected);
		
		actual =  spySL.get(1).getEndDate();
		expected = LocalDate.parse("2020-10-31");
		assertEquals(actual, expected);
		
		actual =  spySL.get(2).getEndDate();
		expected = LocalDate.parse("2020-11-07");
		assertEquals(actual, expected);
	}

}
