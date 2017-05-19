package shouty;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoutSteps {
	private static final String ARBITRARY_MESSAGE = "Hello, world";
	@Autowired
	private ShoutyHelper shoutyHelper;


	
	@When("^(Sean|Oscar|Lucy) shouts$")
	public void sean_shouts(String name) throws Throwable {
		shoutyHelper.shouty.shout(name, ARBITRARY_MESSAGE);
	}

	@Then("^Lucy should hear Sean")
	public void lucy_should_hear_sean() throws Throwable {
		assertEquals(1, shoutyHelper.shouty.getMessagesHeardBy("Lucy").size());
	}

	@Then("^Lucy should hear nothing$")
	public void lucy_should_hear_nothing() throws Throwable {
		assertEquals(emptyMap(), shoutyHelper.shouty.getMessagesHeardBy("Lucy"));
	}

	@Then("^Lucy should not hear Oscar")
	public void lucy_should_not_hear_oscar() throws Throwable {
		assertTrue(shoutyHelper.shouty.getMessagesHeardBy("Lucy").get("Oscar") == null);
	}

	@Then("^Lucy should hear (\\d+) shouts from Sean$")
	public void lucyShouldHearShoutsFromSean(int arg1) throws Throwable {
	    int nbrshouts = shoutyHelper.shouty.getMessagesHeardBy("Lucy").get("Sean").size();
	    assertEquals(arg1, nbrshouts);
	}
}
