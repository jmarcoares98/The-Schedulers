package projectScheduler;

 

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
 

public class Testevent {

 

       Event spyEvent = spy(new Event("Party", "2020-10-30", "2020-10-31","halloween", "Holidays"));

       Member spyMember = spy(new Member("bob","123@hotmail"));
       
      

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
             
             
             
             
             Event se = spy(new Event("evname", "2020-10-30", "2020-10-31", "descr", "projname"));
 			 se.addMember(new Member("matt","abc@gmail.com"));
 			 doReturn("matt").when(se).getName(); 
 			 assertEquals("matt",se.getMemberNames()); 	
             
             
             
             

       }

 

	    // Purpose is to make sure this method working properly, thus use mocking for get MemberNames
	   	@Test
	   	public void testFormatEvents() {
	   		
	   		String actual = spyEvent.formatEvents();

            String expected = "2020-10-31 Holidays: Party- ";

            assertEquals(actual, expected);
	   		
	   		
	   		Event se = spy(new Event());
	   		//Event se = mock(Event.class);
	   		doReturn(LocalDate.parse("2020-10-31")).when(se).getEndDate();
	   		doReturn("projname").when(se).getProjectname();
	   		doReturn("evname").when(se).getName();
	   		doReturn("membernames").when(se).getMemberNames();
	   		assertEquals("2020-10-31 projname: evname- membernames",se.formatEvents());
	   		
	   		
	   		
	   	}
        
	   	
	   	//BB
	   	// false date
	   	@Test
	   	public void testBlackboxEvent() {
	   	  		
	   		Event se = spy(new Event());
	   		doReturn(LocalDate.parse("2020-02-31")).when(se).getEndDate();
	   		doReturn("projname").when(se).getProjectname();
	   		doReturn("evname").when(se).getName();
	   		doReturn("membernames").when(se).getMemberNames();
	   		assertEquals("2020-10-31 projname: evname- membernames",se.formatEvents());

	   	}
	   	
	   	
       
	   	// incorrect date format
	   	@Test
	   	public void testBlackboxEvent2() {   		
	   		   		
	   		Event se = spy(new Event());
	   		doReturn(LocalDate.parse("2020/10/29")).when(se).getEndDate();
	   		doReturn("projname").when(se).getProjectname();
	   		doReturn("evname").when(se).getName();
	   		doReturn("membernames").when(se).getMemberNames();
	   		assertEquals("2020-10-29 projname: evname- membernames",se.formatEvents());

	   	}
	   	@Test
	   	public void testBlackboxEvent2Correct() {   		
	   		   		
	   		Event se = spy(new Event());
	   		doReturn(LocalDate.parse("2020-10-29")).when(se).getEndDate();
	   		doReturn("projname").when(se).getProjectname();
	   		doReturn("evname").when(se).getName();
	   		doReturn("membernames").when(se).getMemberNames();
	   		assertEquals("2020-10-29 projname: evname- membernames",se.formatEvents());

	   	}
	   	
	   	
       
}