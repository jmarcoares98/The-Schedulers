package projectScheduler;

 

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

 

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

       }

 

       @Test

       public void testFormatEvents() {

             String actual = spyEvent.formatEvents();

             String expected = "2020-10-31 Holidays: Party- ";

             assertEquals(actual, expected);

       }

 

}