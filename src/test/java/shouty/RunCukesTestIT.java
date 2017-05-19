package shouty;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber",
		"rerun:target/rerun.txt" }, snippets = SnippetType.CAMELCASE)
public class RunCukesTestIT {
}
