package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/Features/Login1.feature","src/test/resources/Features/Customers.feature"},
				glue="stepDefinition",
			   
			    
				monochrome=true,
				dryRun=false,
				//publish=true,
			    //plugin= {"pretty","html:target/htmlReport","json:target/JSONReport/report.json"}
				plugin= {"pretty","html:test-output"}
		
		)
public class TestRun {

}
