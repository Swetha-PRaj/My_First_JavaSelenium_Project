package com.sat.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.BrandSettingsPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyUserIsAbleToDisableServiceWithATimePeriodForSelectedBrand {
public WebDriver driver;

	
private BrandSettingsPage brandstng = new BrandSettingsPage(TestBase.getDriver());
StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
BookingAppLoginPage balp = new BookingAppLoginPage(TestBase.getDriver());
	
    @When("Select brands {string}")
    public void select_brands(String brandName) {
    	brandstng.selectBrand(brandName);
    }
    @And("select enabled {string}")
    public void select_enabled(String ServiceName) {
    	brandstng.selectService(ServiceName);
    }
    @Then("click on Add Time Period")
    public void click_on_Add_Time_Period() {
    	brandstng.addTimePeriod();
    }
    @Then("input {string} {string} {string} {string} {string} and {string}")
    public void input_and(String fmDate,String fmYear,String fmMonth,String tDate,String tYear,String tMonth) {
    	brandstng.selectFromDateAndToDate(fmDate,fmYear,fmMonth, tDate,tYear,tMonth);
    }
    @And("click on apply and ok")
    public void click_on_apply_and_ok() {
    	brandstng.clickOnApply();
    	brandstng.clickOnRefresh();
    }

}
