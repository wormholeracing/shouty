package shouty;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ShoutyHooks {
	@Before("@wip")
	public void beforeHooks() {
		System.out.println("Before Hooks applied");
	}

	@After
	public void afterHooks() {
		System.out.println("After Hooks applied");
	}
}
