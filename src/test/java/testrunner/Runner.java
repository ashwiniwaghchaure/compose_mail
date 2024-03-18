package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/compose_email.feature", 
glue = { "stepdefination" }, 
plugin = {"pretty", "html:target/cucumber.html" },
dryRun = false, 
monochrome = true 
)




public class Runner extends AbstractTestNGCucumberTests {

}
