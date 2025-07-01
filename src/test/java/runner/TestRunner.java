package runner;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/features/RciAffiliate.feature",          // Path to .feature files
    glue = {"stepdefinitions", "hooks", "config", "pages", "driverUtilities"}  ,   // Step defs, hooks, config, etc.
    plugin = {
        "pretty",                                      // Console output
        "html:target/cucumber-html-report.html",       // HTML report
        "json:target/cucumber.json"                    // JSON report (for CI/ExtentReports)
    },
    monochrome = true,
    dryRun = false
    //tags = "@Smoke"
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

	
	
	
}
