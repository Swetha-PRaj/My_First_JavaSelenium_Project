package com.sat.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.StoreCalendarsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VerifyAdminStaffUserIsAbleToCloseTheService {
public WebDriver driver;
	
	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	
	@Then("Select the service {string}")
	public void select_the_service(String service) {
		StoreCalendars.selectService(service);
	}
	@And("Enter the Customise message {string}")
	public void enter_the_customise_message(String customMsg) {
		StoreCalendars.enterCustomMessage(customMsg);
	}
	@Then("check all the services are {string} for {string}")
	public void check_all_the_services_are_for(String serviceStatus, String storeName) {
		storestng.clickOnSettings();
		storestng.clickOnStoreSettings();
		storestng.storeServicesEnableorDisable(serviceStatus, storeName);
	}
	
	@And("check the service status and {string} {string}")
	public void check_the_service_and(String viewStatus, String noOfdefaultvisitors) {
		StoreCalendars.setServiceStatus(viewStatus, noOfdefaultvisitors);
	}
	
}
