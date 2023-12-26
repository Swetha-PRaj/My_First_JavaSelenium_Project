package com.sat.StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleHomePage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.Pages.StatusUpdatePage;
import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewItemResaleAppStepDefs {

	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleLoginPage resalregister = new ResaleLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private GmailLoginPage gmail = new GmailLoginPage(TestBase.getDriver());
	private ResaleHomePage resaleHomePage = new ResaleHomePage(TestBase.getDriver());
	private ConfigFileReader config = new ConfigFileReader();
	Testutil testutil = new Testutil();
	private StatusUpdatePage statusPage = new StatusUpdatePage(TestBase.getDriver());
	
	@Given("user launching ResaleApp with valid credentials and signin")
	public void user_launching_ResaleApp_with_valid_credentials_and_signin() throws InterruptedException {
		TestBase.getDriver().get(config.getEmailUrl());
		gmail.enterEmail(config.getEmailUserid());
		gmail.enterPassword(config.getEmailPassword());
		gmail.unReadAllMails();
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
	}

	@When("selecting {string},{string},{string}")
	public void selecting(String brand, String country, String store) throws InterruptedException {
		manageuser.selectedStore(brand, country, store);
	}

	@And("searching for existing seller {string},{string}")
	public void searching_for_existing_seller(String existingUser, String tabSelection) throws InterruptedException {
		resalelogin.selectExistingSeller(existingUser, tabSelection);
		
	}
	@Given("naviagte to manage users section and search with {string} and select role to {string} and save it")
	public void naviagte_to_manage_users_section_and_search_with_and_select_role_to_and_save_it(String searchtext,
			String role) throws InterruptedException {
		manageuser.goToManageusers();
		manageuser.userSelection(searchtext, role);
		manageuser.save();
		manageuser.validateMsg();
		manageuser.signOut();
	}

	@And("click on Add Item button and enter {string} and select {string} and click Next button and enter sign save it")
	public void click_on_Add_Item_button_and_enter_and_select_and_click_Next_button_and_enter_sign_save_it(
			String noOfItems, String unsoldItem) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.addPendingItem(noOfItems, unsoldItem);
	}
	@Then("sign agreement for {string} item")
	public void sign_agreement_for_item(String status) {
		resalelogin.itemsTab();
		resalelogin.signAgreementForPreregstr(status);
	}
	@And("Open the {string} item and validate")
	public void open_the_item_and_validate(String status) throws InterruptedException {
		resalelogin.openItem(status);
		resalelogin.getSizeListValidation();
	}

	@And("click on {string} item and generate id by clicking on edit button and save it")
	public void click_on_item_and_generate_id_by_clicking_on_edit_button_and_save_it(String status)
			throws InterruptedException, AWTException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.idGeneration();
		//resalelogin.removeItems();
		//resalelogin.removeForLoop();
		//resalelogin.countPages();
	}
	
	@Then ("Click on the Add New Brand and validate pop up msg {string},{string}")
	public void click_the_AddNewBrand(String poptext, String popcomment) {
		resalelogin.clickOnAddNewBrand(poptext,popcomment);
	}
	  @Then ("User navigated to {string} tab")
	  public void click_the_pending(String tabSelection) throws InterruptedException
	  {
		  resalelogin.selectpendingscreen(tabSelection);
	  }
	  @Then ("Verify column {string} are not appering on the screen")
	  public void verify_all_tab_appering_on_pending(String form,DataTable datatable) throws InterruptedException
	  {
		  
		  resalelogin.ValidatealltabPending(form,datatable);
		  Thread.sleep(5000);
	  }
	 
	  @And ("open Item and validate {string} are not appering on the screen is not present")
	  public void openItem_verify_field_not_present(String opentab) throws InterruptedException
	  {
		  
		  resalelogin.OpenTab_verifyfields(opentab);
		  Thread.sleep(5000);
	  }
	@And ("Observe, Unsold item {string} status is hidden")
	public void Unsoldhidden(String unsolditem ) {
		resalelogin.UnsoldTabhidden(unsolditem);
		resalelogin.uploadImageInItemPage();
		//resalelogin.okBtn();
	}
	
	 @And ("Click on Cancel Button in item page")
	 public void Click_on_cancel_btn_itempage() {
		 resalelogin.ClickCancelItem();
		 resalelogin.okBtn();
		 
	 }
	 
	@And ("User is able to view the comment given by seller")
	public void Validate_Comment() {
		resalelogin.ValidateSeller();
	}
	
	@Then ("close the item")
	public void close_the_item() {
		resalelogin.clickOnCalcelbtnAndOk();
	}
	@And ("Validate the message new brand is added {string} and also validate item already exist")
	public void ValidateNewBrandAdded(String Newbrand) {
		Boolean isEntered= resalelogin.EnterNewBrand(Newbrand);
		if (isEntered == true) {
			resalelogin.validateTextExist(Newbrand);
		}
		
		else
		{
		 resalelogin.validateNewBrandAddedMsg();
	}
	}

	@Then("user will receive email as {string}")
	public void user_will_receive_email_as(String subject) {
		resalelogin.switchTab();
		TestBase.getDriver().get(config.getEmailUrl());
		gmail.Validation(subject);
		resalelogin.switchToOriginal();
	}
	
	@And("clickng on {string} and fill details {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void clickng_on_and_fil_details(String status, String brand, String gender, String category, String size,
			String condition, String material,String color, String price, String store, String year, String month, String date,
			String unsoldItem) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.brandSelection(brand);
		resalelogin.genderSelection(gender);
		resalelogin.categorySelection(category);
		resalelogin.sizeSelection(size);
		resalelogin.conditionSelection(condition);
		resalelogin.materialSelection(material);
		resalelogin.colorSelection(color);
		resalelogin.priceSelection(price);
		resalelogin.storeSelection(store);
		resalelogin.calendarSelection(year, month, date);
		resalelogin.uploadImageInItemPage();
		//resalelogin.unsoldItemSelection(unsoldItem);
	}
	@And("click on {string} and fil details {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and save it")
	public void click_on_and_enter_and_save_it(String status, String brand, String gender, String category, String size,
			String condition, String material,String color, String price, String store, String year, String month, String date,
			String unsoldItem) throws InterruptedException, AWTException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.brandSelection(brand);
		resalelogin.genderSelection(gender);
		resalelogin.categorySelection(category);
		resalelogin.sizeSelection(size);
		resalelogin.conditionSelection(condition);
		resalelogin.materialSelection(material);
		resalelogin.colorSelection(color);
		resalelogin.priceSelection(price);
		resalelogin.storeSelection(store);
		resalelogin.calendarSelection(year, month, date);
		//resalelogin.unsoldItemSelection(unsoldItem);
		resalelogin.uploadImageInItemPage();
		resalelogin.pendingSave();
	}

	@Then("Save it")
	public void Save_it()
	{
		resalelogin.pendingSave();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@And("open the created item {string} and update all details including price{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void open_the_created_item_and_update_all_details_including_price(String status, String brand, String gender,
			String category, String size, String condition, String material,String color, String price, String store, String year,
			String month, String date, String imagepath) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.brandSelection(brand);
		resalelogin.genderSelection(gender);
		resalelogin.categorySelection(category);
		resalelogin.sizeSelection(size);
		resalelogin.conditionSelection(condition);
		resalelogin.materialSelection(material);
		resalelogin.colorSelection(color);
		resalelogin.priceSelection(price);
		resalelogin.storeSelection(store);
		resalelogin.calendarSelection(year, month, date);
		//resalelogin.uploadImageInItemPage(imagepath);
		//resalelogin.unsoldItemSelection(unsoldItem);
		resalelogin.pendingSave();
		System.out.println("Donebutton");
		resalelogin.donePendingItem();
	}

	@Given("naviagte to manage users section and search with {string} and select role to {string},store to {string} and save it")
	public void naviagte_to_manage_users_section_and_search_with_and_select_role_to_and_save_it(String searchtext,
			String role, String store) throws InterruptedException {
		System.out.println("Step 13 is completed");
		Thread.sleep(5000);
		System.out.println("Step to click on Manage User");
		manageuser.goToManageusers();
		manageuser.userSelection(searchtext, role);
		System.out.println("Step to click on Manage UserCh Store");
		manageuser.manageUserChStore(store);
		System.out.println("Step to click on Save");
		manageuser.save();
		manageuser.validateMsg();
		manageuser.signOut();
		System.out.println("Step 16 is completed");
	}
	//Neha_4997
	@Given("naviagte to manage users section and search with {string} and select role to {string} and save")
	public void naviagte_to_manage_users_section_and_search_with_and_select_role_to_and_save(String searchtext,
			String role) throws InterruptedException {
		
		manageuser.goToManageusers();
		manageuser.userSelection(searchtext, role);
		manageuser.save();
		//manageuser.validateMsgPop();
		//testutil.validatesuccessmsg(driver, null);
		manageuser.signOut();
		Thread.sleep(10000);
		System.out.println("Sighout is complted");
	}
	@And("Generate unique ID for {string}and update the mandatory fields {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} for {string}")
	public void Generate_unique_ID_for_and_update_the_mandatory_fields_for(String status, String Brand, String Gender, String Category,String Size, String Condition, String Material, String Color, String Price, String Store, String year, String month, String date, String ImagePath,String noOfIter) throws InterruptedException{
		int no_itr= Integer.parseInt(noOfIter);
		for(int i=0; i<no_itr; i++){
			resalelogin.itemsTab();
			resalelogin.openItem(status);
			resalelogin.idGeneration();
			resalelogin.itemsTab();
			resalelogin.openItem(status);
			resalelogin.brandSelection(Brand);
			resalelogin.genderSelection(Gender);
			resalelogin.categorySelection(Category);
			resalelogin.sizeSelection(Size);
			resalelogin.conditionSelection(Condition);
			resalelogin.materialSelection(Material);
			resalelogin.colorSelection(Color);
			resalelogin.priceSelection(Price);
			resalelogin.storeSelection(Store);
			resalelogin.calendarSelection(year, month, date);
			resalelogin.uploadImageInItemPage();
			//resalelogin.unsoldItemSelection(unsoldItem);
			resalelogin.pendingSave();
			//resalelogin.donePendingItem();
		}
	
	}
	   
	@And("get the Item id for {string} {string} items, navigate to status update tab and change the status to")
	public void get_the_item_id_for_items_naviagte_to_status_update_tab_and_change_the_status_to(String no_of_itr, String status, DataTable changestatus) {
		Robot robot;
		try {
			robot = new Robot();
			System.out.println("About to zoom in");
			for (int k = 0; k < 4; k++) {
				System.out.println("executing for loop");
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statusPage.changingTheStatus(no_of_itr, status, changestatus);
	}
	

	@Then("user login to ResaleApp and search for {string},{string}")
	public void user_login_to_resaleapp_and_search_for1(String existingSeller,
			String tabSelection) throws InterruptedException {
		TestBase.getDriver().manage().deleteAllCookies();
		System.out.println("entering the url");
		TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());
		//resalenewhomepage.ClickHomeResaleBackButton();
		resalelogin.selectExistingSeller(existingSeller, tabSelection);
	}
}
