package com.githubTaskProject.step_defs;


import com.githubTaskProject.utils.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {



	
	@After(value = "@ui")
	public void tearDown(Scenario scenario) {
		// only takes a screenshot if the scenario fails
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

	}


	@After(value = "@ui")
	public void tearDownWebDriver(){

		Driver.closeDriver();
	}
	
	
	
	
	
}
