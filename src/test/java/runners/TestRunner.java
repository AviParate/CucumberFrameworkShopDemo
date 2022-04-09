package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\functionalTests",
glue= {"stepDefinitions"},
plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
,monochrome = true
)

public class TestRunner {

}
