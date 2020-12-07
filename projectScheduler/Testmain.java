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
	
	
	
	
	
	//We don't know how to mock in order for Arraylist sort to work properly so this unit test does not use mocking
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
		
		//BB
		spyPL.add(new Project("Pname3", "Pdesc3"));	
		//add event
		spyPL.get(2).Events.add(new Event("Ename4", "2020-12-05", "2020-12-01","Edesc4",spyPL.get(1).getName()));
		
		spySL = x.orderEvents(spyPL);
		
		actual =  spySL.get(3).getStartDate();
		expected = LocalDate.parse("2020-12-05");
		assertEquals(actual, expected);
		
		actual =  spySL.get(3).getEndDate();
		expected = LocalDate.parse("2020-12-01");
		assertEquals(actual, expected);
		
		
	}

	//BlackBox
	//Tests inp3 has to be formatted correct (name-email) or (name1-email1/name2-email2/etc-etc)
	@Test
	public void testAddproject(){
		Main m = new Main();
		ArrayList<Project> spyPL = spy(new ArrayList<Project>());
		spyPL.add(new Project("Pname", "Pdesc"));
		
		
		spyPL=m.addProject(spyPL, "Pname", "Pdesc", "name email");
		String actual = (spyPL).get(0).getMembers().get(0).getName();
		String expected = "name"; 
		assertEquals(actual,expected);
		
	}
	@Test
	public void testAddprojectCorrect(){
		Main m = new Main();
		ArrayList<Project> spyPL = spy(new ArrayList<Project>());
		
		spyPL=m.addProject(spyPL, "Pname", "Pdesc", "name-email");
		String actual = (spyPL).get(0).getMembers().get(0).getName();
		String expected = "name"; 
		assertEquals(actual,expected);
		
	}

	//if inp1 is not an integer or is an integer that is greater than or less than the project list size, the program crashes.
	@Test 
	  public void test_rmProject(){
	    String works = "1";
	    String improperFormat = "one"; 
	    Main x = new Main();
	    ArrayList<Project> spyList = spy(new ArrayList<Project>());
	    spyList.add(new Project ("projName1", "projDescr1")); 
	    spyList.add(new Project ("projName2", "projDescr2"));
	    ArrayList<Project> compareList = new ArrayList<Project>();
	    spyList=x.removeProject(spyList,works);
	    assertEquals("projName2", spyList.get(0).getName()); 
	    spyList.add(new Project ("projName3", "projDescr3"));
	    spyList=x.removeProject(spyList,improperFormat);
	    assertEquals("projName3", spyList.get(0).getName());
	    
	  }
	@Test 
	  public void test_rmProject2(){
	    String works = "1";
	    String improperValue = "3"; 
	    Main r = new Main();
	    ArrayList<Project> spyList2 = spy(new ArrayList<Project>());
	    spyList2.add(new Project ("projName1", "projDescr1")); 
	    spyList2.add(new Project ("projName2", "projDescr2"));
	    ArrayList<Project> compareList = new ArrayList<Project>();
	    spyList2=r.removeProject(spyList2,works);
	    assertEquals("projName2", spyList2.get(0).getName()); 
	    spyList2.add(new Project ("projName3", "projDescr3"));
	    spyList2=r.removeProject(spyList2,improperValue);
	    assertEquals("projName3", spyList2.get(0).getName());
	    
	  }
	//if inp1 is not an integer or is an integer that is greater than or less than the project list size, the program crashes.
	@Test 
	  public void testAddEvent1_1(){//Works
		//Setup
		Main m = new Main();
		ArrayList<Project> spyPL = spy(new ArrayList<Project>());
		String[] strL;
		String[] strL2;
		
		strL = "name1-email1/name2-email2".split("/");
		spyPL.add(new Project ("projName1", "projDescr1")); 
		for(String s : strL) {
			strL2 = s.split("-");
			spyPL.get(spyPL.size() - 1).addMember(new Member(strL2[0],strL2[1]));
		}
		//Test
		
		spyPL=m.addEvent(spyPL, "1","Eventname","Eventdesc","2020-12-13","2020-12-14","1/2");
		assertEquals("Eventname", spyPL.get(0).Events.get(0).getName());//works
	}
	@Test 
	  public void testAddEvent1_2(){//if inp1 is not an integer
		//Setup
		Main m = new Main();
		ArrayList<Project> spyPL = spy(new ArrayList<Project>());
		String[] strL;
		String[] strL2;
		
		strL = "name1-email1/name2-email2".split("/");
		spyPL.add(new Project ("projName1", "projDescr1")); 
		for(String s : strL) {
			strL2 = s.split("-");
			spyPL.get(spyPL.size() - 1).addMember(new Member(strL2[0],strL2[1]));
		}
		//Test
		
		spyPL=m.addEvent(spyPL, "one","Eventname","Eventdesc","2020-12-13","2020-12-14","1/2");
		assertEquals("Eventname", spyPL.get(0).Events.get(0).getName());//fails
	}
	@Test 
	  public void testAddEvent1_3(){//is an integer that is greater than or less than the project list size
		//Setup
		Main m = new Main();
		ArrayList<Project> spyPL = spy(new ArrayList<Project>());
		String[] strL;
		String[] strL2;
		
		strL = "name1-email1/name2-email2".split("/");
		spyPL.add(new Project ("projName1", "projDescr1")); 
		for(String s : strL) {
			strL2 = s.split("-");
			spyPL.get(spyPL.size() - 1).addMember(new Member(strL2[0],strL2[1]));
		}
		//Test
		
		spyPL=m.addEvent(spyPL, "2","Eventname","Eventdesc","2020-12-13","2020-12-14","1/2");
		assertEquals("Eventname", spyPL.get(0).Events.get(0).getName());//fails
	}
	
	//if inp4 and inp5 is formatted incorrectly or if the String converted to a LocalDate is not a real date, the program crashes.
	@Test 
	  public void testAddEvent2_1(){//if inp4 or inp5 is formatted incorrectly
		//Setup
		Main m = new Main();
		ArrayList<Project> spyPL = spy(new ArrayList<Project>());
		String[] strL;
		String[] strL2;
		
		strL = "name1-email1/name2-email2".split("/");
		spyPL.add(new Project ("projName1", "projDescr1")); 
		for(String s : strL) {
			strL2 = s.split("-");
			spyPL.get(spyPL.size() - 1).addMember(new Member(strL2[0],strL2[1]));
		}
		//Test
		
		spyPL=m.addEvent(spyPL, "1","Eventname","Eventdesc","2020/12/13","2020-12-14","1/2");
		assertEquals("Eventname", spyPL.get(0).Events.get(0).getName());//fails
	}
	
	@Test 
	  public void testAddEvent2_2(){//if the String converted to a LocalDate is not a real date
		//Setup
		Main m = new Main();
		ArrayList<Project> spyPL = spy(new ArrayList<Project>());
		String[] strL;
		String[] strL2;
		
		strL = "name1-email1/name2-email2".split("/");
		spyPL.add(new Project ("projName1", "projDescr1")); 
		for(String s : strL) {
			strL2 = s.split("-");
			spyPL.get(spyPL.size() - 1).addMember(new Member(strL2[0],strL2[1]));
		}
		//Test
		
		spyPL=m.addEvent(spyPL, "1","Eventname","Eventdesc","2020-12-13","2021-02-31","1/2");
		assertEquals("Eventname", spyPL.get(0).Events.get(0).getName());//fails
	}
	
	//if inp6 is not an integer or is an integer that is greater than or less than the project list size, the program crashes.
	@Test 
	  public void testAddEvent3_1(){//if inp6 is not an integer
		//Setup
		Main m = new Main();
		ArrayList<Project> spyPL = spy(new ArrayList<Project>());
		String[] strL;
		String[] strL2;
		
		strL = "name1-email1/name2-email2".split("/");
		spyPL.add(new Project ("projName1", "projDescr1")); 
		for(String s : strL) {
			strL2 = s.split("-");
			spyPL.get(spyPL.size() - 1).addMember(new Member(strL2[0],strL2[1]));
		}
		//Test
		
		spyPL=m.addEvent(spyPL, "1","Eventname","Eventdesc","2020-12-13","2020-12-14","one/two");
		assertEquals("Eventname", spyPL.get(0).Events.get(0).getName());//fails
	}
	
		@Test 
		  public void testAddEvent3_2(){//is an integer that is greater than or less than the project list size
			//Setup
			Main m = new Main();
			ArrayList<Project> spyPL = spy(new ArrayList<Project>());
			String[] strL;
			String[] strL2;
			
			strL = "name1-email1/name2-email2".split("/");
			spyPL.add(new Project ("projName1", "projDescr1")); 
			for(String s : strL) {
				strL2 = s.split("-");
				spyPL.get(spyPL.size() - 1).addMember(new Member(strL2[0],strL2[1]));
			}
			//Test
			
			spyPL=m.addEvent(spyPL, "1","Eventname","Eventdesc","2020-12-13","2020-12-14","1/3");
			assertEquals("Eventname", spyPL.get(0).Events.get(0).getName());//fails
		}
	
		//if inp6 is formatted incorrectly (not in num/num/etc format), the program crashes.
		@Test 
		  public void testAddEvent4_1(){
			//Setup
			Main m = new Main();
			ArrayList<Project> spyPL = spy(new ArrayList<Project>());
			String[] strL;
			String[] strL2;
			
			strL = "name1-email1/name2-email2".split("/");
			spyPL.add(new Project ("projName1", "projDescr1")); 
			for(String s : strL) {
				strL2 = s.split("-");
				spyPL.get(spyPL.size() - 1).addMember(new Member(strL2[0],strL2[1]));
			}
			//Test
			
			spyPL=m.addEvent(spyPL, "1","Eventname","Eventdesc","2020-12-13","2020-12-14","1-2");
			assertEquals("Eventname", spyPL.get(0).Events.get(0).getName());//fails
		}
		
		//inp6 can add the same member multiple times if formatted incorrectly (EX:1/1/2/1).
				@Test 
				  public void testAddEvent5_1(){
					//Setup
					Main m = new Main();
					ArrayList<Project> spyPL = spy(new ArrayList<Project>());
					String[] strL;
					String[] strL2;
					
					strL = "name1-email1/name2-email2".split("/");
					spyPL.add(new Project ("projName1", "projDescr1")); 
					for(String s : strL) {
						strL2 = s.split("-");
						spyPL.get(spyPL.size() - 1).addMember(new Member(strL2[0],strL2[1]));
					}
					//Test
					
					spyPL=m.addEvent(spyPL, "1","Eventname","Eventdesc","2020-12-13","2020-12-14","1/1/2/1");
					assertEquals("Eventname", spyPL.get(0).Events.get(0).getName());//works but shouldn't
				}
				
		
		
		
		
		
}
