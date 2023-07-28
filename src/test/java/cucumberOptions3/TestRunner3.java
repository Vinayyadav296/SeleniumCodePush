package cucumberOptions3;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/",glue= {"stepDefinitions3","helper3"},tags="@Reg",plugin="html:target/test/htmlReport.html")
public class TestRunner3 {

}
