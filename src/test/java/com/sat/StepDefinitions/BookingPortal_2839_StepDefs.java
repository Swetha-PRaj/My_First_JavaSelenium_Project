package com.sat.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.PowerAppsAutomateFlowPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.Then;

public class BookingPortal_2839_StepDefs {
	public WebDriver driver;
	
	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());

	private ConfigFileReader config = new ConfigFileReader();
	private PowerAppsAutomateFlowPage power = new PowerAppsAutomateFlowPage(TestBase.getDriver());

	
	
	@Then("Run the cloud flow {string}")
	public void run_the_cloud_flow(String cloudFlowName) {
		TestBase.getDriver().get(config.getPowerAppAdminCloudFlow());
		power.runCloudFlow(cloudFlowName);
	}
	
	
	
	
	
}
