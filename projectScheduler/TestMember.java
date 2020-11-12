package projectScheduler;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;



public class Testmember {

	
	Member spyMember = spy(new Member("bob","123@hotmail"));
	
	
	@Test
	public void testMember() {
		Member sm = spy(new Member("bob","123@gmail.com")); 
		String expName = "bob";
		String expEmail = "123@gmail.com";
		assertEquals(expName,sm.getName());
		assertEquals(expEmail,sm.getEmail());
	}
	
	
	
	
	
	@Test
	public void testformatMember() {

		assertEquals("(5) bob: 123@hotmail",spyMember.formatMember(5));
		spyMember.setName("Daniel");
		spyMember.setEmail("DLH@gmail.com");
		assertEquals("(5) Daniel: DLH@gmail.com",spyMember.formatMember(5));
		
		
		Member sm = spy(new Member()); 
		int i = 1;
		doReturn("bob").when(sm).getName(); 
		doReturn("123@gmail.com").when(sm).getEmail();
		assertEquals("(1) bob: 123@gmail.com",sm.formatMember(i)); 
		
		
	}

}
