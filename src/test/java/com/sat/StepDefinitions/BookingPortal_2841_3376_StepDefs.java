package com.sat.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.BookingPortalPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.Then;

public class BookingPortal_2841_3376_StepDefs {
	public WebDriver driver;
	
	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	private BookingPortalPage bookingPortal = new BookingPortalPage(TestBase.getDriver());

	
	@Then("click on Cancle Booking Button and click on Yes verify cancelled msg and {string}")
	public void click_on_Cancle_Booking_Button_and_click_on_Yesverify_cancelled_msg_and(String helpmail) {
		bookingPortal.cancleBooking();
		bookingPortal.clickOnYesbtnAndVerifyMsg(helpmail);
	}
	
}
