package executions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = {"classpath:Executions"},

		glue = {"executions"},

		plugin = {"pretty","html:target/cucumber-reports/reports.html",
				"json:target/cucumber-report.json"
		},
		
		tags = "@Sanity",
		
		publish = true

		)

public class amazonrunner extends AbstractTestNGCucumberTests {

}
