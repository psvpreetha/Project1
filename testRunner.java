package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="D:\\MyProject\\Eclipse\\DBSProject\\src\\test\\java\\Feature\\DBSExercise.feature"
			,glue= {"stepDefinitions"},
			plugin = {"pretty", "html:target/Cucumber-reports"},
					monochrome= true
)
public class testRunner 
{

}
