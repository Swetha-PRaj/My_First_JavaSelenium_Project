package com.sat.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.CountrySettingsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VerifyUserIsSAbleToAddANewServiceAndViewServiceToStoreForSelectedBrandAndCountryInAdminCanvasApp {
public WebDriver driver;
	

private CountrySettingsPage CountrySetting = new CountrySettingsPage(TestBase.getDriver());
StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());

	@Then("Navigate to store settings")
	public void navigate_to_store_settings() {
		storestng.clickOnSettings();
		storestng.clickOnStoreSettings();
	}
	@Then("select the Store {string}")
	public void select_the_store(String storeName) {
		storestng.selectStoreCheckBox(storeName);
	}
	@Then("click on Add button and Ok button")
	public void click_on_Add_button_and_Ok_button() {
		CountrySetting.clickAdd();
		CountrySetting.clickOk();
	}
	@And("Validate success message")
	public void validate_success_message() {
		storestng.validateServiceAddedMsgInStoreLevel();
	}
	
}
