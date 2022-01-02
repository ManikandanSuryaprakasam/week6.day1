package runnerTest1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Feature path and step definition package name
@CucumberOptions(features="src/test/java/featuresTest1/Login.feature",
glue="stepdefinitionTest1"
,monochrome=true,publish = true)

public class CucumberRunner extends AbstractTestNGCucumberTests {
	
	
	
	

}
