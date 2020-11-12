package projectScheduler;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class IntegrationTests {

	@Test 
	public void Integrate_Member_With_Event() {
		Member m1 = spy(new Member("matt","abc@gmail.com")); 
		if ("matt"==m1.getName()){
			Event se = spy(new Event("evname", "2020-10-30", "2020-10-31", "descr", "projname"));
			se.addMember(new Member("matt","abc@gmail.com"));
			assertEquals("matt",se.getMemberNames()); 
		}
		else {
			assertEquals(1,2);
		}
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


   @Test
   public void testorderEventstoFormatEventsIntegration() {
	   ArrayList<Project> spyPL = spy(new ArrayList<Project>());
   	   ArrayList<Event> spySL= new ArrayList<Event>();
   	   Main x = new Main();

	//adds new project with 2 members
		spyPL.add(new Project("Pname1", "Pdesc1"));	
		
		//add event
		spyPL.get(0).Events.add(new Event("Ename1", "2020-10-30", "2020-10-31","Edesc1",spyPL.get(0).getName()));
		
		//add event
		spyPL.get(0).Events.add(new Event("Ename2", "2020-11-03", "2020-11-07","Edesc2",spyPL.get(0).getName()));
		
		spySL = x.orderEvents(spyPL);
		
		String actual =  spySL.get(0).formatEvents();
		String expected = "2020-10-31 Pname1: Ename1- ";
		assertEquals(actual, expected);
		
		actual =  spySL.get(1).formatEvents();
		expected = "2020-11-07 Pname1: Ename2- ";
		assertEquals(actual, expected);
		
		//adds new project
		spyPL.add(new Project("Pname2", "Pdesc2"));	
		//add event
		spyPL.get(1).Events.add(new Event("Ename3", "2020-09-13", "2020-09-15","Edesc3",spyPL.get(1).getName()));
		
		spySL = x.orderEvents(spyPL);
		
		actual =  spySL.get(0).formatEvents();
		expected = "2020-09-15 Pname2: Ename3- ";
		assertEquals(actual, expected);
		
		actual =  spySL.get(1).formatEvents();
		expected = "2020-10-31 Pname1: Ename1- ";
		assertEquals(actual, expected);
		
		actual =  spySL.get(2).formatEvents();
		expected = "2020-11-07 Pname1: Ename2- ";;
		assertEquals(actual, expected);
   }
}
