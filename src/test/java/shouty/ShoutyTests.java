package shouty;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShoutyTests {

	private static final String ARBITRARY_MESSAGE = "Hello, world";
	private final Shouty shouty = new Shouty();

	@Test
	public void test_that_shouter_doesnt_hear_their_own_shouts() {
		Coordinate coord = new Coordinate(0,0);
		shouty.setLocation("Lucy", coord);
		shouty.shout("Lucy", ARBITRARY_MESSAGE);
		assertTrue(shouty.getMessagesHeardBy("Lucy").isEmpty());
	}
}
