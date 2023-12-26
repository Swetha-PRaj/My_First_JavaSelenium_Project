package com.sat.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.StoreCalendarsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VerifyServiceCalendarsWhenStoreisclosedStepDefs {
public WebDriver driver;
	
	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());
	
    @Then("Select Apply Button and verify success message")
    public void Select_Apply_Button_and_verify_success_message() throws InterruptedException {
    	StoreCalendars.selectApplyhAndVerifySuccessMsg();
	}
    @And("Verify service Calendar is {string}")
    public void Verify_service_calendar(String statusOfCalander) {
    	StoreCalendars.verificationOfCalender(statusOfCalander);
    }
}
