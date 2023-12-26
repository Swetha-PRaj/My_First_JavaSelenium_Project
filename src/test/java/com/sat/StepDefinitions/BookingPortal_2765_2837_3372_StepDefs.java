package com.sat.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.BookingPortalPage;
import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.Pages.StoreCalendarsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingPortal_2765_2837_3372_StepDefs {
	public WebDriver driver;
	

	private BookingAppLoginPage BookingAppLogin = new BookingAppLoginPage(TestBase.getDriver());
	private ResaleAppLoginPage ResaleAppLogin = new ResaleAppLoginPage(TestBase.getDriver());
	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	private BookingPortalPage bookingPortal = new BookingPortalPage(TestBase.getDriver());
	private GmailLoginPage gmailLoginPage = new GmailLoginPage(TestBase.getDriver());
	private ConfigFileReader config = new ConfigFileReader();
	private ResaleLoginPage resalregister = new ResaleLoginPage(TestBase.getDriver());
	
	
	@Given("Login to Admin tool App")
	public void login_to_Admin_tool_App() {
		TestBase.getDriver().get(config.getApplicationUrl());
		BookingAppLogin.EnterUserName(config.AdminUserName());
		BookingAppLogin.EnterPassword(config.AdminUserPassword());		
	}	
	@When("navigate to store settings")
	public void navigate_to_store_setings() {
		storestng.clickOnSettings();
		storestng.clickOnStoreSettings();
		
	}
	@When("select brand {string} and country {string}")
	public void select_Brand_And_Country(String Brand, String Country) throws InterruptedException {
		storestng.selectStoreSettingBrand(Brand);
		storestng.selectStoreSettingCountry(Country);
	}
	@Then("Select store {string}")
	public void select_store(String storeName) {
		storestng.clickOnStore(storeName);
	}
	@And("click on {string} Settings")
	public void click_one_settings(String serviceName) {
		storestng.clickOnService(serviceName);
	}
	@Then("check the display in portal view is {string} for the service")
	public void check_the_display_in_portal_view_is_for_the_service(String viewStatus) {
		storestng.displayInPortalView(viewStatus);
	}
	@Then("change the Country {string} and brand {string}")
	public void change_the_country_and_bran(String Country, String Brand) {
		StoreCalendars.setCountryAndBrand(Country,Brand);
	}
	@When("clicked on store Calendar then select store {string} and check the {string}")
	public void clicked_on_store_calendar(String nameOfTheStore, String storeState) {
		StoreCalendars.storeIsOpenOrClose(storeState, nameOfTheStore);
	}
	@Then("check calendar is generated for the {string} if not generate calendar {string} {string} {string} {string} {string} {string}")
	public void check_calendar_is_generated_for_the_if_not_generate_calendar(String serviceName,String fmDate,String fmYear,String fmMonth,String tDate,String tYear,String tMonth) {
		StoreCalendars.checkCalendarForService(serviceName,fmDate,fmYear,fmMonth,tDate,tYear,tMonth);
		StoreCalendars.editSelectedSlot(serviceName);

	}
	@Then("check calender is not generated for the {string} {string} {string} {string} {string} {string} {string}")
	public void check_calender_is_not_generated(String serviceName,String Brand, String Country,String storeName,String click_MeetstoreName,String viewStatus,String url) throws InterruptedException {
		//StoreCalendars.checkNoCalendarForService(serviceName);
		Boolean Fielddisplay= StoreCalendars.checkNoCalendarForService(serviceName);
		if (Fielddisplay==true)
		{
			System.out.println("No Calender is displayed return True");
			storestng.clickOnSettings();
			storestng.clickOnStoreSettings();
			storestng.selectStoreSettingBrand(Brand);
			storestng.selectStoreSettingCountry(Country);
			storestng.clickOnStore(storeName);
			storestng.clickOnService(serviceName);
			storestng.displayInPortalView(viewStatus);
			TestBase.getDriver().get(config.ClickMeetForAutomationServiceTest(url));
			bookingPortal.checkStoreAndClickOnIt(click_MeetstoreName);
			
		}
		else
		{
			System.out.println("No Calender is not displayed return false");
			Boolean Enddatedisplay=StoreCalendars.checkEndDateForService(serviceName);
			if (Enddatedisplay==true)
			{
				storestng.clickOnSettings();
				storestng.clickOnStoreSettings();
				storestng.selectStoreSettingBrand(Brand);
				storestng.selectStoreSettingCountry(Country);
				storestng.clickOnStore(storeName);
				storestng.clickOnService(serviceName);
				storestng.displayInPortalView(viewStatus);
				TestBase.getDriver().get(config.ClickMeetForAutomationServiceTest(url));
				bookingPortal.checkStoreAndClickOnIt(click_MeetstoreName);
			}
			else
			{
				System.out.println("Invalid Scenario");
			}
		}
	}
	@Then("check calender is not generated for the Resale Portal {string} {string} {string} {string} {string} {string} and log in resale portal {string} {string} {string}")
	public void check_calender_is_not_generated_Resale_Portal(String serviceName,String Brand, String Country,String storeName,String click_MeetstoreName,String viewStatus,String url,String user, String password) throws InterruptedException {
		//StoreCalendars.checkNoCalendarForService(serviceName);
		Boolean Fielddisplay= StoreCalendars.checkNoCalendarForService(serviceName);
		if (Fielddisplay==true)
		{
			System.out.println("No Calender is displayed return True");
			storestng.clickOnSettings();
			storestng.clickOnStoreSettings();
			storestng.selectStoreSettingBrand(Brand);
			storestng.selectStoreSettingCountry(Country);
			storestng.clickOnStore(storeName);
			storestng.clickOnService(serviceName);
			storestng.displayInPortalView(viewStatus);
			TestBase.getDriver().get(config.getResalePortalUrl1(url));    
			resalregister.loginResalePortal(config.getResalePortaluserId(user),config.getResalePortalpassword(password));
			resalregister.clickonsignin();
			//bookingPortal.checkStoreAndClickOnIt(click_MeetstoreName);
		}
		else
		{
			System.out.println("No Calender is not displayed return false");
			Boolean Enddatedisplay=StoreCalendars.checkEndDateForService(serviceName);
			if (Enddatedisplay==true)
			{
				storestng.clickOnSettings();
				storestng.clickOnStoreSettings();
				storestng.selectStoreSettingBrand(Brand);
				storestng.selectStoreSettingCountry(Country);
				storestng.clickOnStore(storeName);
				storestng.clickOnService(serviceName);
				storestng.displayInPortalView(viewStatus);
				TestBase.getDriver().get(config.getResalePortalUrl1(url));    
				resalregister.loginResalePortal(config.getResalePortaluserId(user),config.getResalePortalpassword(password));
				resalregister.clickonsignin();
				//bookingPortal.checkStoreAndClickOnIt(click_MeetstoreName);
			}
			else
			{
				System.out.println("Invalid Scenario");
			}
		}
	}
	
	@Then("Validate the message is displayed on selecting today date from the Select date & time {string}")
	public void validate_the_text_present_on_selected_date_and_time(String ExpectedString)
	{
		storestng.testAssertExpextedText(ExpectedString);
	}
	
	@And("Click on Next available time then the validate message {string} {string}")
	public void Click_on_Next_available_time(String ExpectedString , String splitStrng)
	{
		storestng.testAssertClicknext(ExpectedString, splitStrng);
	}
	
	 
	 @And("Validate No time Slot msg {string} {string}")
		public void Validate_no_timeSlot(String ExpectedString , String ExpectedString2)
		{
			storestng.ValidateNoSlotMsg(ExpectedString, ExpectedString2);
		}
	@And("open booking portal url")
	public void open_booking_portal_url() throws InterruptedException {

	}	
	@And("open booking portal url {string}")
	public void open_booking_portal_url(String url) throws InterruptedException {

		TestBase.getDriver().get(config.getEmailUrl());
		//gmailLoginPage.enterEmail(config.getEmailUserid());
		//gmailLoginPage.enterPassword(config.getEmailPassword());
		//gmailLoginPage.unReadAllMails();
		TestBase.getDriver().get(config.bookingPortalUrl(url));
	}
	
	@Then("select Slot Date {string} {string} {string}")
	public void select_slot_date(String setMonth, String setYear, String setDate)	{
		bookingPortal.selectSlotDate(setMonth, setYear, setDate);
	}
	@And("validate the date format")
	public void vlaidate_the_date_formate() throws InterruptedException {
		bookingPortal.validateDateFormat();
	}
	@Then("Check and click on the store {string}")
	public void check_and_click_on_the_store(String storeName) {
		bookingPortal.checkStoreAndClickOnIt(storeName);
	}
	@And("selct the time slot which is enable {string}")
	public void select_the_time_slot_which_is_enable(String bookingSlotTime) {
		bookingPortal.checkEnabledSlotAndClickOnIt(bookingSlotTime);
	}
	@Then("enter required contact details {string} {string} {string} {string} {string} {string}")
	public void enter_required_contact_details(String contactName, String contactEmail, String contactMobile, String contactAddress,String contactPostcode,String contactCity) {
		bookingPortal.enterContactDetails(contactName, contactEmail, contactMobile, contactAddress, contactPostcode, contactCity);
	}
	@Then("validate contact fields {string} {string} {string} {string} {string}")
	public void validate_contact_fields(String Name,String Email,String phoneno,String address,String helpmail) throws InterruptedException {
		bookingPortal.validateContactDetails(Name, Email, phoneno, address, helpmail);
	}
	@Then("validate confirmation page is displayed and Extend button is removed")
	public void validate_confirmatin_page_and_Extend_Booking_button()throws InterruptedException {
		bookingPortal.validateConfirmationExtendButton();
	}
	
	@Then("click on done")
	public void click_on_done() {
		bookingPortal.clickOnDone();
	}
	@And("Validate confirmation mail with subject {string}")
	public void validate_confirmation_mail(String emailSubject) {
		TestBase.getDriver().get(config.getEmailUrl());
		gmailLoginPage.Validation(emailSubject);
	}
	@Then("click on Cancle Button")
	public void click_on_cancle_button() {
		bookingPortal.clickOnCancle();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("validate the Done button")
    public void validate_the_Done_Button() {
        bookingPortal.Click_ResalePortal_Done();
    }
	@And("click on gmail back button")
	public void click_on_gmail_back_button() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gmailLoginPage.backBtn();
	}
	@Then("Check the Email Link available")
	public void Check_the_Email_Link_available() 
	{
		gmailLoginPage.checkTheEmailLink();
	}
	@And("Confirm the cancellation in Cancel your Booking")
	public void Confirm_the_cancellation_in_Cancel_your_Booking() 
	{
		ResaleAppLogin.switchToActiveTab();
		//ResaleAppLogin.switchTab();
		gmailLoginPage.Click_on_cancellation();
	}
	@Then("open new tab and enter the gmailurl")
	public void open_new_tab_and_enter_the_gmailurl() 
	{
		ResaleAppLogin.switchTab();
		gmailLoginPage.NewTabEnterGmailLink();
	}
}
