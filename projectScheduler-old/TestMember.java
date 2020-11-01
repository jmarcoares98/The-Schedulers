package projectScheduler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class TestMember {

	
	Member spyMember = spy(new Member("bob","123@hotmail"));

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testformatMember() {
		doReturn("Daniel").when(spyMember).getName();
		doReturn("DLH@gmail.com").when(spyMember).getEmail();
		
		assertEquals("(5) Daniel: DLH@gmail.com",spyMember.formatMember(5));
		
		fail("Not yet implemented");
	}

}
