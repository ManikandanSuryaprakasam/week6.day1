package leafTapRunnerTest2;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/leaftapFeature",glue="leafTapStepDef",monochrome= false,publish = true)
public class LeafTapRunner extends AbstractTestNGCucumberTests {
	
	
	

}
