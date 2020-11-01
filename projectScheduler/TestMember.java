package projectScheduler;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;



public class Testmember {

	
	Member spyMember = spy(new Member("bob","123@hotmail"));
	
	
	@Test
	public void testformatMember() {
		//doReturn("Daniel").when(spyMember).getName();
		//doReturn("DLH@gmail.com").when(spyMember).getEmail();
		//Member M = new Member("Daniel","DLH@gmail.com");
		//assertEquals(5,5);
		assertEquals("(5) bob: 123@hotmail",spyMember.formatMember(5));
		//assertEquals("(5) Daniel: DLH@gmail.com",M.formatMember(5));
		//fail("Not yet implemented");
	}

}
