package br.com.dgelli.Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/*
 * To run in Grip, just work with Web 
 * and Run with TestNG
 * 
 * To run in sequence use JUnit
 * 
 * */
@RunWith(Cucumber.class)
@CucumberOptions(

		monochrome = false,
		plugin = { "html:output/CucumberReport", "json:output/CucumberReport/cucumber.json", "br.com.dgelli.framework.Hooks" }, 
		features = { "src/test/java/features" }, 
		glue = { "br.com.dgelli.steps", "br.com.dgelli.framework" }, 
		
		tags = { "@regression" }
		
		// tags = { "@MockAPI" }
		// tags = { "@DesckTop" }
		// tags = { "@login" }
		// tags = { "@mobile" }
		
		// tags = { "@gridchrome, @gridfirefox, @gridedge" }
		// tags = { "@gridchrome" }
)

public class RunnerTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
}