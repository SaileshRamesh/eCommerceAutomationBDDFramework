package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = 	"src/test/java/features",
		glue ="stepdef",
		tags = "@ValidateProductViaSearch",
		monochrome = true,
		dryRun = false,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider
	(parallel= true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
