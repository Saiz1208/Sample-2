package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = { "src/main/features/resource.feature" },
        glue = { "steps",
                "hooks" },
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        plugin = { "pretty", "html:reports",
                "junit:reports/result.xml", "json:reports/result.json" }
//		tags= {"@smoke,@reg"}

)
public class runner extends AbstractTestNGCucumberTests {
    public static void main(String[] args) throws InterruptedException {

    }
}
