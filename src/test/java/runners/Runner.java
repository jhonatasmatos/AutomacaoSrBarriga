package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@CucumberOptions(
		plugin = "pretty",
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		glue = "steps",
		features = "src/test/resources/features/login.feature",
		dryRun = false,
		strict = true
		)
@RunWith(Cucumber.class)
public class Runner {
	
}
