package com.sat.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.BrandSettingsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VerifyUserIsAbleToAddANewServiceForSelectedBrand {
	public WebDriver driver;
	
	private BrandSettingsPage brandstng = new BrandSettingsPage(TestBase.getDriver());
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());
	
	
	@Then("Navigate to brand settings")
    public void navigate_to_brand_settings() {
		storestng.clickOnSettings();
		brandstng.selectBrandSettings();
    	
    }
    @And("Select brand {string}")
    public void Select_brand(String brandName) {
    	brandstng.selectBrand(brandName);
  	
    }
    @Then("Click on Add service")
    public void click_on_add_service() {
    	brandstng.clickOnAddService();
    	
    }
    @Then("Enable status toggle button should be {string}")
    public void enable_status_toggle_button_should_be_Enabled(String togglebtn) {
    	brandstng.selectToggleButton(togglebtn);	
    }
    
    @And("Specify display name {string} and {string}")
    public void spicify_dispay_name(String dispName, String APIName) {
    	brandstng.enterDisplayAndApiName(dispName, APIName);
    }
    @Then("Click on Add and Ok")
    public void click_on_add_and_ok() {
    	brandstng.clickAddAndOk();
    }
    @And("Verify the service {string} in the list")
    public void verify_the_service_in_the_list(String verifyDispalyName) {
    	brandstng.validateserviceaddedsucessfully();
    	brandstng.clickOnRefresh();
    	brandstng.verifyServiceAdd(verifyDispalyName);
    }
    

}
