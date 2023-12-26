package com.sat.StepDefinitions;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleAppNewHomeLoginPage;
import com.sat.Pages.ResaleHomePage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IBANnumValidationStpDefs {
	public WebDriver driver;

	private ResaleLoginPage resalregister = new ResaleLoginPage(TestBase.getDriver());
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleLoginPage resalepagelogin = new ResaleLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private ResaleHomePage resalehmPage = new ResaleHomePage(TestBase.getDriver());

	private ResaleAppNewHomeLoginPage resalenewhomepage = new ResaleAppNewHomeLoginPage(TestBase.getDriver());

	private Properties prop;


	private ConfigFileReader config = new ConfigFileReader();	
	@Given("user go to login page {string} and click on Create an account link")
	public void user_go_to_login_page_and_click_on_Create_an_account_link(String url1) {
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		resalregister.createAccount();
	}

	@And("enter the mandatory fileds {string} and  {string} and {string} and {string} and {string} and {string} and {string} in the page")
	public void enter_the_mandatory_fileds_and_and_and_and_and_and_and_in_the_page(String email,
			String fname, String lname, String phonenumber, String address, String postalcode, String city) {
		resalregister.fillRegistrationFormDetails(email, fname, lname, phonenumber, address, postalcode, city);;
	}

	@And("click on Continue button")
	public void click_on_Continue_button() {
		//resalregister.continuetonextpage();
	}

	@When("user navigating to ResaleApp with valid credentials and signin")
	public void user_navigating_to_ResaleApp_with_valid_credentials_and_signin() throws InterruptedException {
		/*TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());*/
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
		manageuser.ClickHomeResaleBackButton();
	}
	@Then("open resale app")
	public void open_resale_app() {
		TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.switchToFrame();
		manageuser.ClickHomeResaleBackButton();
	}

	@When("select {string},{string},{string}")
	public void select(String brand, String country, String store) throws InterruptedException {
		manageuser.selectedStore(brand,country,store);
	}

	@And("search for existing seller {string},{string}")
	public void serach_for_existing_seller(String existingUser, String tabSelection) throws InterruptedException {
		resalelogin.selectExistingSeller(existingUser,tabSelection);
	}
	
	@Then("validate the seller {string}")
	public void validate_the_seller(String newSeller) {
		resalelogin.validate_sellerTab_Email(newSeller);
	}
	
	
	
	@Then("select the multiple item by selecting the checkbox")
	public void select_multiple_chkbox() {
		resalelogin.pendingSave();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resalelogin.selectMultipleItem();
	}
	 @And("Click on three dots and {string} for the selected items")
	 public void ChangeStatusExpiredScreen(String store)
	 {
		 resalelogin.for_change_expired_status(store);
	 }
	 
	@Then("validate seller commission Field {string}")
	public void validate_seller_commission_Field(String ststus) {
		resalelogin.validateCommissionField(ststus);
	}
	
	@Then("validate seller commission Field in Item page {string}")
	public void validate_seller_commission_field_in_item_page(String status){
		resalelogin.validateComissionFiledInItemPage(status);
	}
	
	@Then("Open the {string} item")
	public void open_the_item(String status) throws InterruptedException {
		resalelogin.openItem(status);
	}
	
	
	@Then("Verify the commission field")
	public void verify_commission_field() {
		resalelogin.verifyCommissionField();
	}
	@Then("update seller comission {string}")
	public void updateSellerComissionString(String cmsnpercentage) {
		resalelogin.updateSellerComission(cmsnpercentage);
	}
	@And("Go to items Tab")
	public void got_to_items_tab() {
		resalelogin.itemsTab();
	}
	@Then("open the item {string}")
	public void poen_the_item(String status) throws InterruptedException {
		resalelogin.openItem(status);
	}

	@And("select checkboxes and give {string} and save it")
	public void select_checkboxes_and_give_and_save_it(String iban) throws InterruptedException {
		resalelogin.empAndBankChkbox();
		resalelogin.fillingIBANNumber(config.getIban(iban));

	}

	@And("select the both of the checkboxes and enter the {string} and save it")
	public void select_the_both_of_the_checkboxes_and_enter_the_and_save_it(String iban) throws InterruptedException {
	    resalelogin.empAndBankChkbox();
		resalelogin.fillingIBANNumber(config.getIban(iban));
	  
	}
	@And("validate the IBAN number {string}")
	public void validate_the_IBAN_number(String iban) {
		resalelogin.IBANnumValidation(config.getIban(iban));
		resalelogin.signAgreement();
	}

	@Then("Login to Resalepportal {string},{string} and delete the created seller")
	public void login_to_Resalepportal_and_delete_the_created_seller(String url1, String user1) throws InterruptedException {
		config.refresh();
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
		//String password=config.getResalePortalpassword(user1);
		resalepagelogin.loginResalePortal(user1,config.getTemporaryPassword());
		resalepagelogin.clickonsignin();
		resalepagelogin.deleteSeller();
	}
	@Then("Select HM group employee and bank account check boxes")
	public void select_HM_goroup_employee_and_bank_account_check_boxes() {
		resalelogin.empAndBankChkbox();
	}
	@And("Sign the agreement")
	public void sign_the_agreement() {
		resalelogin.signAgreement();
	}
	@Then("save the seller settings")
	public void save_the_seller_settings() {
		resalelogin.saveBtn();
	}
	@Then("select country settings and enter the commision {string}")
	public void  select_country_and_enter_the_commision(String countryComision) {
		resalehmPage.addCommissionInCountry(countryComision);
	}
	@Then("validate seller commission with {string}")
	public void validate_the_commission_with(String countryComision) {
		resalehmPage.validateSellerCommission(countryComision);
	}
	@Then("change the seller commission {string}")
	public void change_the_seller_commission(String sellerCommission) {
		resalehmPage.updateSellerCommission(sellerCommission);
	}

	@Then("navigate to Items Tab")
	public void navigate_to_items_tab() {
		resalelogin.itemsTab();
	}
	@Then("open the {string} item and validate the commission with {string}")
	public void poen_the_item_and_validate_the_commission_with(String status, String countryComision) throws InterruptedException, AWTException {
		resalelogin.openItem(status);
		resalehmPage.validateItemCommission(countryComision);
		resalelogin.Deleteallitems();
	}
	@And("update item commission and validate")
	public void update_item_commission_and_validate(DataTable table) throws InterruptedException {
		resalehmPage.updateAndValidateItemCommission(table);
	}
	@Then("save pending item")
	public void save_pending_item() {
		resalelogin.pendingSave();
	}

	@Then("navigate to brand settings update commission {string}")
	public void navigate_to_brand_settings_update_commission(String brandComision) {
		resalehmPage.addCommissionInBrandStng(brandComision);
	}
	@Then("validate Brand commission")
	public void validate_brand_commission(DataTable table) throws InterruptedException {
		resalehmPage.ValidateCommissionInBrandStng(table);
	}
	@Then("user login to ResaleApp")
	public void user_login_ro_ResaleApp() throws InterruptedException {	
		TestBase.getDriver().manage().deleteAllCookies();
		System.out.println("entering the url");
		TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());
		manageuser.ClickHomeResaleBackButton();
	}
	@And("Click on one of the item in All items tab")
	public void click_on_one_of_the_item_in_all_items_tab() {
		manageuser.clickOnTheItem();
	}
	@Then("validate commission field is displayed or not")
	public void validate_commission_field_is_displayed_or_not() {
		manageuser.validateCommissionField();
	}
	@And("commission filed should be disabled or read only")
	public void commission_filed_should_be_disabled_or_read_only() {
		manageuser.validateDisableStatus();
	}
	@Then("user login to ResaleApp and then select {string} {string} {string} search for {string},{string} update created item {string} to {string}")
	public void user_login_to_ResaleApp_and_search_for_the_click_on_and_update_created_item_to_new_fun(String existingSeller,String tabSelection, String status, String Updatedstatus,String brand,String country,String store) throws InterruptedException {
		System.out.println("Step 17 started");
		TestBase.getDriver().manage().deleteAllCookies();
		TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());
		Thread.sleep(10000);
		System.out.println("click on back button");
		resalenewhomepage.ClickHomeResaleBackButton();
		Thread.sleep(10000);
		System.out.println("select brand store and country");
		manageuser.selectedStore(brand,country,store);
		Thread.sleep(10000);
		System.out.println("select existing seller");
		resalelogin.selectExistingSeller(existingSeller, tabSelection);
		resalelogin.itemsTab();
		resalelogin.updateStatus(status, Updatedstatus);
	}
}
