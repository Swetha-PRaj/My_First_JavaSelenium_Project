package com.sat.StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sat.Pages.B2BHomePage;
import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.BookingPortalPage;
import com.sat.Pages.BrandSettingsPage;
import com.sat.Pages.CountrySettingsPage;
import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.PowerAppsAutomateFlowPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleAppNewHomeLoginPage;
import com.sat.Pages.ResaleHomePage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.Pages.StoreCalendarsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class B2BHomePageStepDefs {

	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private ConfigFileReader config = new ConfigFileReader();
	private B2BHomePage bbhomepage=new B2BHomePage(TestBase.getDriver());
	private ResaleAppNewHomeLoginPage resalenewhomepage = new ResaleAppNewHomeLoginPage(TestBase.getDriver());
	
	
	@When("user navigating to B2BAppHomePage with valid credentials and signin")
	public void user_navigating_to_B2BApp_with_valid_credentials_and_signin() throws InterruptedException {
		/*TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());*/
		TestBase.getDriver().get(config.getB2BHomeAppUrl());
		manageuser.B2BLogin(config.B2BAppUserId(), config.B2BAppPassword());
	}
	@Then("validate B2B entity {string} and {string}")
	public void validate_B2B_entity(String ManageNewItem,String ManageExpiredItem) throws InterruptedException {
		bbhomepage.validateB2BhomeEntity(ManageNewItem, ManageExpiredItem);
	}
	@Then("verify all entities are appearing under Manage new items")
    public void verify_all_tabs_are_appearing_on_the_Contact_Form(DataTable datatable) {
        try {
        	bbhomepage.verifyentity(datatable);
        } catch (Exception e) {
            System.out.println("Exception :" + e + " has occurred");
        }
    }
	@Then("verify all entities are appearing on the left panel Common Task")
    public void verify_all_entities_are_appearing_on_the_left_panel(DataTable datatable) {
        try {
        	bbhomepage.validateleftpanel(datatable);
        } catch (Exception e) {
            System.out.println("Exception :" + e + " has occurred");
        }
    }
	 @And("click on New Order button")
	 public void click_on_new_order_button()
	 {
		 bbhomepage.Click_new_order();
		 
	 }
	 @Then("navigate to New Order")
	 public void click_order()
	 {
		 bbhomepage.Click_order();
	 }
	 @And("click on upload file to excel {string} and Click on done button")
	 public void Click_on_upload_file(String downloadedPath)
	 {
		 bbhomepage.clickOnUploadExcel(downloadedPath);
	 }
	 @Then("verify all entities are appearing on the pending screen")
	    public void verify_entities_are_appearing_on_the_pending_screen(DataTable datatable) {
		try {
	        	bbhomepage.validatependingScren1_3(datatable);
	        } catch (Exception e) {
	            System.out.println("Exception :" + e + " has occurred");
	        }
	    }
	 
	 @And("click on next button")
	 public void next_button() {
	        try {
	        	bbhomepage.next_button_click();
	        } catch (Exception e) {
	            System.out.println("Exception :" + e + " has occurred");
	        }
	    }
	 @And("Click on Scan parcel button")
	 public void scan_parcel()
	 {
		 try {
	        	bbhomepage.scan_parcel_click();
	        } catch (Exception e) {
	            System.out.println("Exception :" + e + " has occurred");
	        }
	 }
	 @Then("Validate the following entities present in the register parcel ID")
	 public void validate_parcelID(DataTable datatable)
	 {

		 try {
	        	bbhomepage.validate_parcelId(datatable);
	        } catch (Exception e) {
	            System.out.println("Exception :" + e + " has occurred");
	        }
	 }
	 @And("Generate the unique parcel ID and click on done")
	 public void generate_parcelID()
	 {
		 try {
	        	bbhomepage.generate_parcelId();
	        } catch (Exception e) {
	            System.out.println("Exception :" + e + " has occurred");
	        }
	 }
	 @And("click on Home button")
	 public void Click_homebtn()
	 {
		 bbhomepage.Click_homebtn();
	 }
	 @Then("Validate the count of sending In-transit")
	 public void valiadte_count()
	 {
		 bbhomepage.validate_intransit_count();
	 }
	 @And("Click on Sending In-transit and valiadate the detail matches with uploaded file")
	 public void click_sending_Intransit_validate_deatils_with_uploaded_file(DataTable datatable)
	 {
		 bbhomepage.Validatesending_Intransit(datatable);
	 }
	 @Then("validate the field data with entities {string}")
	 public void validate_excelfield(String exlpath,DataTable datatable) throws IOException
	 {
		 bbhomepage.Validate_exceldata(exlpath,datatable);
	 }
	//feature 2 for B2B existing item 
	 @And("Click on New Order pending {string} and {string}")
	 public void Click_NewPending(String store,String  Store_no) throws IOException
	 {
		 bbhomepage.Click_NewOrderPending(store,Store_no);
	 }
	 @And("verify the text display with yellow color highlight {string}")
	 public void text_appearsYellow(String excelpath) throws IOException
	 {
		 bbhomepage.validate_textyellow(excelpath);
	 }
	 @And("click on upload file to excel {string}")
	 public void upload_excel_pending(String excelpath) throws IOException
	 {
		 bbhomepage.click_excel_pending(excelpath);
	 }
	 @Then("validate under {string} following Entity")
	 public void validateactionneed(String actionneed,DataTable datatable) throws IOException, InterruptedException
	 {
		 bbhomepage.validate_actionneeded(actionneed,datatable);
	 }
	 @Then("Validate the count of sending In-transit in resale app with B2B app")
	 public void Sending_Intransit_resaleapp() throws IOException, InterruptedException
	 {
		 bbhomepage.Sending_Intransit_resaleapp();
	 }
	 @And("validate the following field are present in {string}")
	 public void Sending_and_receiving(String tab,DataTable datatable) throws IOException, InterruptedException
	 {
		 bbhomepage.Validate_Sending_and_receiving(tab,datatable);
	 }
	 @And("validate the count for Sending and receiving count")
	 public void Sending_and_receiving_count() throws IOException, InterruptedException
	 {
		 bbhomepage.ValidateSendingandreceivingcount();
	 }
	 }

              
            
             


