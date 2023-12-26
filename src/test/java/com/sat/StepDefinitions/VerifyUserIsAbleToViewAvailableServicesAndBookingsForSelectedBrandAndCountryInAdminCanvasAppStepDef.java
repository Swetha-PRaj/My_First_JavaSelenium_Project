package com.sat.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.StoreCalendarsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;

public class VerifyUserIsAbleToViewAvailableServicesAndBookingsForSelectedBrandAndCountryInAdminCanvasAppStepDef {
	public WebDriver driver;

	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());


	@And("validate services {string} under the available service")
	public void validate_services_under_the_available_service(String serviceName) {
		StoreCalendars.validateListOfServices(serviceName);
	}
	@And("click on Booking tab and veify the booking slots for {string}")
	public void click_on_Booking_tab_and_veify_the_booking_slots_for(String serviceName) {
		StoreCalendars.clickOnBookingTabAndValidateService(serviceName);
	}



}
