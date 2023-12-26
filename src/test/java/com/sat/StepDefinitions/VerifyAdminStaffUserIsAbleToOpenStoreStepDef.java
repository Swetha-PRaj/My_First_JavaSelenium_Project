package com.sat.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.StoreCalendarsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;

public class VerifyAdminStaffUserIsAbleToOpenStoreStepDef {
	public WebDriver driver;
	
	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	
	@And("Enter default allowed visitors {string}")
	public void defaultAllowedVisitors(String defaultAlowedVisitor) {
		StoreCalendars.enterDefaultVisitor(defaultAlowedVisitor);
	}
	@And("User click Yes and able to see Successfully store Opened Message")
	public void user_click_yes_and_able_see_Successfully_store_Opened_Message() {
		StoreCalendars.selectYesAndVerifySuccessOpenMsg();
	}
}
