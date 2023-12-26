package com.sat.StepDefinitions;

import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.ResalRegisterItemPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResalePortalLoginStepDefs {

	private ResaleLoginPage resalepagelogin = new ResaleLoginPage(TestBase.getDriver());
	private ResalRegisterItemPage registerpage = new ResalRegisterItemPage(TestBase.getDriver());
	private GmailLoginPage gmail = new GmailLoginPage(TestBase.getDriver());
	private ResaleAdminPage resaleadmin = new ResaleAdminPage(TestBase.getDriver());
	private ConfigFileReader config = new ConfigFileReader();

	@When("User navigates to ResalePortal {string} login page")
	public void user_navigates_to_ResalePortal_login_page(String url1) throws InterruptedException {
		TestBase.getDriver().get(config.getEmailUrl());
		gmail.enterEmail(config.getEmailUserid());
		gmail.enterPassword(config.getEmailPassword());
		gmail.unReadAllMails();
		// gmail.signout();
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
	}
	
	@When("User navigates to ResalePortal {string} login page without gmail")
	public void user_navigates_to_ResalePortal_login_page_without_gmail(String url1) throws InterruptedException {
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
	}

	@And("user enters valid ResalePortal {string} and {string}")
	public void user_enters_valid_ResalePortal_and(String user1, String password) throws InterruptedException {
		resalepagelogin.loginResalePortal(config.getResalePortaluserId(user1),
				config.getResalePortalpassword(password));
		Thread.sleep(3000);
	}
	@When ("User navigates to ResalePortal {string}")
	public void user_navigate_to_ResalePortal() {
		
	}
	@When("User navigates to ResalePortal {string} with {string} and {string}")
	public void user_navigates_to_resaleportal_and(String url, String user1, String password) {
		TestBase.getDriver().get(config.getResalePortalUrl1(url));
		try {
			resalepagelogin.loginResalePortal(config.getResalePortaluserId(user1),
					config.getResalePortalpassword(password));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resalepagelogin.clickonsignin();
	}

	@And("click on signin")
	public void clic_on_signin() throws InterruptedException {
		resalepagelogin.clickonsignin();
	}
	@Then("validate My profile, my Items and my Account in home page")
	public void validate_my_profile_my_ityems_my_acccount_in_home_page() throws InterruptedException {
		resalepagelogin.validateResalePortalHomePage();
	}
	@And("Validate the Registered Item and slot booked item under My appointment")
	public void validate_the_registered_item_and_slot_booked_item_under_my_appointment() throws InterruptedException {
		resalepagelogin.validatMyAppointment();
	}
	@Then("Navigate to my Items and validate the Item")
	public void naviagte_to_my_items_and_validate_the_item() throws InterruptedException {
		resalepagelogin.clickOnMyItem();
		resalepagelogin.validateItem_in_myItems();
	}
	@Then("Navigate to personal deatils and valiate the page is displayed")
	public void navigate_to_personal_details_and_validate_the_page_is_displaye() throws InterruptedException {
		resalepagelogin.goToPersonalDetails();
	}

	@And("veify success msg with username {string}")
	public void veify_success_msg_with_username(String username) {
		resalepagelogin.validateLoginSuccMsg(username);
	}

	@And("click on Registeryouritems")
	public void click_on_registeritems() throws InterruptedException {
		registerpage.registerItem();
	}

	@And("user select or enter below fields {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_select_or_enter_below_fields(String Store_Name, String Brand,String gndr, String Category, String Condition,
			String Color,String Pattern,String Material, String Unsolditem) throws InterruptedException {

		registerpage.selectValues(Store_Name, Brand,gndr, Category, Condition,Color,Pattern, Material, Unsolditem);

	}
	@And("click on registration Submit")
	public void click_on_registration_submit() {
		registerpage.Submit();
	}

	@And("user can view Thankyou Msg")
	public void user_can_view_Thankyou_msg() throws InterruptedException {
		registerpage.regiseteredMsg();
	}

	@And("click on Done and success msg with username {string}")
	public void click_on_Done_and_success_msg_with_username(String username) {
		registerpage.done();
		resalepagelogin.validateLoginSuccMsg(username);
	}
	@Then("Login to the gamil {string} {string}")
	public void login_to_the_gmail(String GmailuserID, String GmailPassword) {
		resalepagelogin.switchTab();
		TestBase.getDriver().get(config.getEmailUrl());
		gmail.enterEmail(config.getGmailUserid(GmailuserID));
		gmail.enterPassword(config.getGmailPassword(GmailPassword));
		
	}

	@Then("confirmation email should sent with {string}")
	public void confirmation_email_should_sent_with(String subject) throws InterruptedException {
		Thread.sleep(3000);
		resalepagelogin.switchTab();
		TestBase.getDriver().get(config.getEmailUrl());
		//gmail.Validation(subject);t
		gmail.ValidationWithoutPromotionTab(subject);
		gmail.backBtn();
	}
	@And("check currently created {string} item is there in MyItems tab")
	public void check_currently_created_item_is_there_in_MyItems_tab(String status) {
		resalepagelogin.switchToOriginal();
		registerpage.myItemsTab();
		registerpage.currentTabValidation(status);
	}
	@Then("Navigate to Resale Portal tab")
	public void navigate_to_resale_portal_tab() {
		resalepagelogin.switchToOriginal();
	}
	@Then("Navigate to manage account")
	public void navigate_to_manage_account() {
		resalepagelogin.goToManageAccount();
		
	}
	@And("Navigate to my agreement page and validate")
	public void navigate_to_my_agreement_page_and_validate() {
		resalepagelogin.goToMyAgreement();
	}
	@Then("try to delete account, validate the popup unable to delete my data and account")
	public void try_to_delete_account_validate_the_popup_unable_to_delete_my_data_and_account() {
		resalepagelogin.switchToOriginal();
		try {
			resalepagelogin.clickOnDeleteSeller();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		resalepagelogin.check_error_msg_unable_to_delete();
	}
	@And("click on Resale portal back button")
	public void click_on_Resale_portal_back_button() {
		resalepagelogin.clickOnBackIcon();
	}
	@Then("click on Send me my data and validate the popup")
	public void click_on_send_me_my_data_and_validate_the_popup() {
		resalepagelogin.sendMeMyData();
	}
	@And("cancel item which is register and check the cancellation email {string}")
	public void cancel_item_which_is_register_and_check_the_cancellation_email(String subject) {
		/*registerpage.myItemsTab();
		registerpage.currentTabValidation(subject);*/
		registerpage.cancelItems();
		resalepagelogin.switchTab();
		gmail.Validation(subject);
	}

}