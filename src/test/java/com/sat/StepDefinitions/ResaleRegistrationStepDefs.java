package com.sat.StepDefinitions;


import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.ResaleAppLoginPage;

import com.sat.Pages.ResaleLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ResaleRegistrationStepDefs {

	private ResaleLoginPage resalregister = new ResaleLoginPage(TestBase.getDriver());

	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private Properties prop;

	private ConfigFileReader config = new ConfigFileReader();
	private GmailLoginPage gmail = new GmailLoginPage(TestBase.getDriver());
	@Given("user naviagtes to login page {string} and click on Create an account link Name {string}")
	public void user_naviagtes_to_login_page_and_click_on_Create_an_account_link(String portal_url, String creatAccountlinkName) {
		System.out.println(" executing step def " + portal_url);
		TestBase.getDriver().get(config.getResalePortalUrl1(portal_url));
		System.out.println("inside step " + portal_url);
		resalregister.createAccount( creatAccountlinkName);
		System.out.println("clicked on create an Account");
		
	}

	@Given("user naviagtes to login page {string} and click on Create an account link")
	public void user_naviagtes_to_login_page_and_click_on_Create_an_account_link(String url1) {
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		resalregister.createAccount();
	}
	
	@Then("user scroll down to till element is visible")
    public void user_scroll_down_to_till_visible() {
		resalregister.scrollDown();
    }
	
	@Then("user scroll down to till My account element is visible and Click on my Account")
    public void user_scroll_down_to_till_My_account_visible_and_Click_on_my_Account() {
		resalregister.scrollDowntoMyAccount();
    }
	@Then("user verifies the field {string}")
    public void user_verifies_region(String fieldname,DataTable data) throws Exception {
		resalregister.user_verifies_countries(fieldname, data);
	}
	
	@Then("Verify Country field is Diabled")
	public void user_verifies_Countries_field_is_Disabled()
	{
		resalregister.VerifyCountryDisableMyAccount();
	}
	@Given("user naviagtes to login page {string}")
	public void user_naviagtes_to_login_page(String url1) {
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		resalregister.createAccount();
	}

	@And("check create account page should have required fields")
	public void check_create_account_page_should_have_required_fields() throws InterruptedException {
		resalregister.verifyFields();
	}
	 @And("click on Cancel {string}")
	    public void click_on_Cancel(String color) {
				resalregister.cancelPopMsg(color);
				
			}
		 
		 @And("click on Cancel {string} on popmsg")
		    public void click_on_Cancel_on_popmsg(String color) {
					resalregister.cancelPopMsgnext(color);
					
				}
		 @And("click on Cancel {string} on popmsg ClickMeet")
		    public void click_on_Cancel_on_popmsg_ClickMeet (String color) {
					resalregister.cancelPopMsgClickMeet(color);
					
				}
		 @Then("click on ClickPortalCancel")
			public void ClickPortalCancel(){
				resalregister.ClickPortalCancelbutton();
			}
		 
		 @Then("Navigate to ClickPortallink")
			public void ClickPortallink(){
				resalregister.ClickPortallink();
			}

		@And("click on Continue")
		public void click_on_Continue() {
			resalregister.continuetonextpage();
		}
		@And("check the Country")
		public void Check_the_country() {
			resalregister.validateCountry();
		}

	@And("check create account page should have required fields {string}")
	public void check_create_account_page_should_have_required_fields(String Languages) throws InterruptedException {
		/* List<String> lang = Languages.asList();
		 for (int i = 0; i < lang.size(); i++) 
		 {
			 resalregister.verifyFields(lang.get(i));
		 }*/
		 resalregister.verifyFields(Languages);
		
	}
	

	@Then ("User login to ResalePortal {string} with registered credential {string} and {string}")
	public void User_login_to_ResalePortal_with_registered_credential(String url1, String user1, String password) throws InterruptedException {
		TestBase.getDriver().get(config.getEmailUrl());
		//gmail.enterEmail(config.getEmailid(user1));
		//gmail.enterPassword(config.getEmailPassword());
		//gmail.unReadAllMails();
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		resalregister.loginResalePortal(config.getResalePortaluserId(user1),config.getResalePortalpassword(password));
		resalregister.clickonsignin();
	}
	
	

	@And("enter all the mandatory fileds {string} and  {string} and {string} and {string} and {string} and {string} and {string} in the page")
	public void enter_all_the_mandatory_fileds_and_and_and_and_and_and_in_the_page(String email, String fname,
			String lname, String phonenumber, String address, String postalcode, String city) {
		resalregister.fillRegistrationFormDetails(email, fname, lname, phonenumber, address, postalcode, city);
	}

	@And("click on Continue verify registered message {string} and click on Ok")
	public void click_on_Continue_verify_registered_message_and_click_on_ok(String success_msg) {
		resalregister.continuetonextpage(success_msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Given("navigate to Admin tool App")
	public void navigate_to_admin_tool_app() {
		TestBase.getDriver().get(config.getApplicationUrl());
	}

	@Then("remove created seller {string} {string}")
	public void remove_created_seller(String user1, String url1) throws InterruptedException {
		resalelogin.switchTab();
		//resalelogin.switchTab();
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		resalregister.loginResalePortal(user1, config.getTemporaryPassword());
		resalregister.clickonsignin();
		resalregister.deleteSeller();
	}
	
}
