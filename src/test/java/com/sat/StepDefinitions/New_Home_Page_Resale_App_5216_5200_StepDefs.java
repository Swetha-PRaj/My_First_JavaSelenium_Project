package com.sat.StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

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

public class New_Home_Page_Resale_App_5216_5200_StepDefs {

	private ResaleLoginPage resalregister = new ResaleLoginPage(TestBase.getDriver());
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleLoginPage resalepagelogin = new ResaleLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private ResaleHomePage resalehmPage = new ResaleHomePage(TestBase.getDriver());
	private ResaleAppNewHomeLoginPage resalenewhomepage = new ResaleAppNewHomeLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	
	
	
	@When("user navigating to ResaleAppHomePage with valid credentials and signin")
	public void user_navigating_to_ResaleApp_with_valid_credentials_and_signin() throws InterruptedException {
		/*TestBase.getDriver().get(config.getResaleAppUrl());
		resalelogin.resaleAppLogin(config.resaleAppUserId(), config.resaleAppPassword());*/
		TestBase.getDriver().get(config.getResaleHomeAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
	}
	
	@Then("verify all tabs are appearing on the Action Needed")
    public void verify_all_tabs_are_appearing_on_the_Contact_Form(DataTable datatable) {
        try {
        	resalenewhomepage.verifyalltab(datatable);
        } catch (Exception e) {
            System.out.println("Exception :" + e + " has occurred");
        }
    }
	@Then("verify all tabs are appearing on the Common Task")
    public void verify_all_tabs_are_appearing_on_the_Common_Task(DataTable datatable) {
        try {
        	resalenewhomepage.verifynexttab(datatable);
        } catch (Exception e) {
            System.out.println("Exception :" + e + " has occurred");
        }
	}
        @Then("verify all tabs are appearing on the Sales Data")
        public void verify_all_tabs_are_appearing_on_the_Sales_Data(DataTable datatable) {
            try {
            	resalenewhomepage.verifynexttab(datatable);
            } catch (Exception e) {
                System.out.println("Exception :" + e + " has occurred");
            }
}
          @And("verify upcoming booking with the date format")
          public void verify_upcoming_booking_with_the_date_format() {
              try {
              	resalenewhomepage.verifydatettab();
              } catch (Exception e) {
                  System.out.println("Exception :" + e + " has occurred");
              }
          }
              @Then("Click to {string} under Common Tasks")
              public void Click_On_under_Common_Tasks(String string) {
            	  try {
                     
            		  resalenewhomepage.Click_FindSeller(string);
            		 // resalenewhomepage.Click_SearchItem(string);
            		  
            	  } catch (Exception e) {
                      System.out.println("Exception :" + e + " has occurred");
                      }
                  	
              }

              @Then ("Click to {string} under Common Tasks and user verify the Item")
              public void Click_to_under_Common_Tasks_and_user_verify_the_Item(String string) {
            	  try {
                     
            		  resalelogin.Click_SearchItem(string);
            		  
            	  } catch (Exception e) {
                      System.out.println("Exception :" + e + " has occurred");}
                  	
              }
              
              @And("user verify the Seller as {string}")
              public void user_verify_the_Seller_as(String seller) {
            	  resalenewhomepage.validateSellerField(seller);
              }
              @Then("get Id for the item")
              public void get_Id_for_the_item(DataTable ItemStatus) {
            	  resalelogin.listOfStatus(ItemStatus);
              }
              @Then ("select multiple item {string} on {string} by selecting the checkbox")
              public void selectchkitemtab(String itemcount,String tab)
              {
            	  try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	  resalelogin.selectmultipleitemTab(itemcount,tab);
              }
             
              @Then("click on Save button")
              public void click_save()
              {
            	  resalelogin.pendingSave(); 
              }
              @And("user verify the Item")
              public void user_verify_the_Item_as() {
            	  resalenewhomepage.validateSearchItem();
              }
                
              @When("navigate to ResaleAppHomePage")
              public void navigate_to_resaleAppHomePage() {
            	  TestBase.getDriver().get(config.getResaleHomeAppUrl());
              }
              
              @Then("click on back button in Home Page")
              public void click_on_back_button_in_Home_Page() throws InterruptedException {
            	  Thread.sleep(5000);
            	  resalenewhomepage.ClickHomeResaleBackButton();
              }
              @Then("User Click on WeekDay on Left Panel")
              public void user_click_on_WeekDay() {
            	  resalenewhomepage.ClickOnWeekDay();
              }
              @And("user is selecting {string},{string},{string}")
              public void user_is_selecting(String brand, String country, String store) throws InterruptedException  {
            	  manageuser.selectedStore(brand, country, store); 
              }
              @Then("user verifies following fields are mandatory on Admin tab")
              public void user_verifies_following_fields_are_mandatory_Admin_Tab(DataTable datatable) throws Exception {
            	 
                      try {
                      	resalenewhomepage.AdminFieldverify(datatable);
                      } catch (Exception e) {
                          System.out.println("Exception :" + e + " has occurred");
              }
              
              }
              @Then("user verifies following fields are mandatory on Seller tab")
              public void user_verifies_following_fields_are_mandatory_on_Seller_Tab(DataTable datatable) throws Exception {
            	 
                      try {
                      	resalenewhomepage.SellerFieldverify(datatable);
                      } catch (Exception e) {
                          System.out.println("Exception :" + e + " has occurred");
              }
                      
              }
}
             


