package testRunner;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features",
glue="stepDefinitions",
monochrome=true,
plugin= {"html:target/cucumber.html","json:target/cucumber.json","junit:target/cucumber.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel=false)
//	public Object[][] scenarios()
//	{
//		return super.scenarios();
//	}
//	@Parameters({"cucumber.filter.tags"})
//    public void setTags(String tags) {
//        System.setProperty("cucumber.filter.tags", tags);
//    }
	@Parameters("cucumber.filter.tags")
    public Object[][] scenarios(@Optional String tags) {
        return super.scenarios();
    }
}
