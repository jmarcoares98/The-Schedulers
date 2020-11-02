package projectScheduler;

 

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

 

public class Testevent {

 

       Event spyEvent = spy(new Event("Party", "2020-10-30", "2020-10-31","halloween", "Holidays"));

       Member spyMember = spy(new Member("bob","123@hotmail"));
       ArrayList<Project> spyPL = spy(new ArrayList<Project>());
   	   ArrayList<Event> spySL= new ArrayList<Event>();
   	   Main x = new Main();
      

       @Test

       public void testGetMemberNames() {
    	   	 spyEvent.addMember(spyMember);
    	   
             String actual = spyEvent.getMemberNames();

             String expected = "bob";

             assertEquals(actual, expected);

             spyEvent.addMember(new Member("sue","sue@hotmail.com"));

             spyEvent.addMember(new Member("mary", "mary@hotmail.com"));

             actual = spyEvent.getMemberNames();

             expected = "bob, sue, mary";
             
             assertEquals(actual, expected);

       }

 

       @Test

       public void testFormatEvents() {

             String actual = spyEvent.formatEvents();

             String expected = "2020-10-31 Holidays: Party- ";

             assertEquals(actual, expected);

       }

 
       @Test
       public void testorderEventstoFormatEventsIntegration() {

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