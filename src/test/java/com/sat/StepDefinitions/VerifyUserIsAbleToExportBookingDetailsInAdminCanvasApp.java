package com.sat.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.StoreSettingsPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VerifyUserIsAbleToExportBookingDetailsInAdminCanvasApp {
public WebDriver driver;
	
	StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	
	@Then("navigate to Store Settings")
	public void navigate_to_Store_Settings() {
		storestng.clickOnSettings();
		storestng.clickOnStoreSettings();
	}
	@And("select {string} more option and click on View Store settings")
	public void select_more_option_and_click_on_view_store_settings(String storeName) {
		storestng.clickOnStoreMoreOption(storeName);
		storestng.clickOnViewStoreSettings();
	}
	@And("click on export to excel")
	public void click_on_export_to_excel() {
		storestng.clickOnExportToExcel();
	}
	 @Then("inputs {string} {string} {string} {string} {string} and {string}")
	    public void input_and(String fmDate,String fmYear,String fmMonth,String tDate,String tYear,String tMonth) {
	    	storestng.selectFromDateAndToDate(fmDate,fmYear,fmMonth, tDate,tYear,tMonth);
	    }
	@And("validate the downloaded file {string} in the {string}")
	public void validate_the_downloaded_file_in_the(String fileName, String downloadedPath) {
		storestng.validateDownloadedFile(downloadedPath, fileName);
	}
	
	
}
