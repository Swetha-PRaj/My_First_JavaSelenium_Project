package com.sat.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.BookingPortalPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;

public class VerifyUserIsAbleToBookATimeAfterRegisteringAnItemsThroughPortalStepDef {
public WebDriver driver;
	

	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	private BookingPortalPage bookingPortal = new BookingPortalPage(TestBase.getDriver());
	
	
	@And("validate Registered Items details {string} {string}")
	public void validate_registered_items_details(String Brand, String CategoryName) {
		bookingPortal.validateRegisteredItems(Brand, CategoryName);
	}
    @And("validate Booking details {string} {string} {string} {string} {string} {string}")
    public void validate_booking_details(String storeName, String date, String month, String year, String Name, String Email) {
    	bookingPortal.validateFromResaleBookingdeails(storeName, date, month, year, Name, Email);
    }


}
