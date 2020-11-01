package projectScheduler;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;



public class Testmember {

	
	Member spyMember = spy(new Member("bob","123@hotmail"));
	
	
	@Test
	public void testformatMember() {

		assertEquals("(5) bob: 123@hotmail",spyMember.formatMember(5));
		spyMember.setName("Daniel");
		spyMember.setEmail("DLH@gmail.com");
		assertEquals("(5) Daniel: DLH@gmail.com",spyMember.formatMember(5));
		
	}

}
