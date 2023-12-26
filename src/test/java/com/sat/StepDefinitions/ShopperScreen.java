package com.sat.StepDefinitions;

import java.util.Properties;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.GmailLoginPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.newAdminToolPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ShopperScreen {
	
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	private BookingAppLoginPage BookingAppLogin = new BookingAppLoginPage(TestBase.getDriver());
	private newAdminToolPage AdminToolapp = new newAdminToolPage(TestBase.getDriver());
	//Given User Navigate to New Admin Tool App
	@Given("User Navigate to New Admin Tool App")
	public void login_to_New_Admin_tool_App() throws InterruptedException {
		TestBase.getDriver().manage().deleteAllCookies();
		Thread.sleep(10000);
		resalelogin.switchTab();
		TestBase.getDriver().get(config.getApplicationUrlNewAdminTool());
		BookingAppLogin.EnterUserName(config.TestUserName());
		BookingAppLogin.EnterPassword(config.AdminUserPassword());	
		//
	}	
	
	@Then("user scroll down to till element is visible in Admin Tool")
    public void user_scroll_down_to_till_visible() {
		AdminToolapp.scrollDownToShopper();
    }
	 @And("Validate user should be able to view the Personal shopper page without any error")
	 public void Check_the_country() {
		 AdminToolapp.validateSuccessMessageAdmin();
		}
	 
	@Then("Click on Add button and search the email Id of the shopper")
	public void Click_On_Add_Button_and_search_shopper()
	{
		 AdminToolapp.ClickAdd();
		 AdminToolapp.SearchShopper(config. getShopperEmailID());
		 AdminToolapp.validateShopperAddedMsg() ;
	}
	@Then("check the {string} and {string} present in the list")
	public void Cleck_On_Shopper_Present_Inlist(String existingSeller, String shopperName)
	{
		 AdminToolapp.RemoveShopper(existingSeller,shopperName);
		 AdminToolapp.validateShopperRemoveMsg();
	}
}
