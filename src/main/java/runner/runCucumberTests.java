/*package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//If feature file path is passed as value for features attribute, 
//all the feature files inside that package will be executed
//To execute a specific feature file, give that specific feature file name
//Glue -> package name of the test cases should be passed
//monochrome -> used to remove/ignore the junk values printed in the console output
//tags -> to execute a specific group of test cases, group name should be passed as value
//tags -> grouping condition can use, and/or/~(Not) operators to get more than one group
@CucumberOptions(features = "src/main/java/feature/Login.feature", glue = {"pages.lead", "testSteps"} , 
				monochrome = true, tags = "@smoke")	//tags = "@smoke and/or/~ @sanity"

@RunWith(Cucumber.class)

public class runCucumberTests {
	
}
*/