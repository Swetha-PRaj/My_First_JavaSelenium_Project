package com.sat.StepDefinitions;

import com.sat.Pages.ResaleAdminPage;

import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleAppNewHomeLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BrandSettingsStepDefs {

	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private ConfigFileReader config = new ConfigFileReader();
    private ResaleAppNewHomeLoginPage resalenewhomepage=new ResaleAppNewHomeLoginPage(TestBase.getDriver());
	@Given("user can launch ResaleApp with valid credentials and signin")
	public void user_can_launch_ResaleApp_with_valid_credentials_and_signin() throws InterruptedException {
		TestBase.getDriver().get(config.getResaleAppUrl());
		manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
		resalenewhomepage.ClickHomeResaleBackButton();
	}

	@And("Go to {string} and select the {string} disable it and click on save")
	public void go_to_and_select_the_disable_it_and_click_on_save(String settings, String brand) throws InterruptedException {
		manageuser.updateBrandSettings(settings);
		manageuser.selectBrand(brand);
		manageuser.selectingToggle();
		manageuser.saveSettings();
	}

	@And("Go to {string} and select the {string} the enable it")
	public void go_to_and_select_the_the_enable_it(String settings, String brand) throws InterruptedException {
		manageuser.selectBrand(brand);
		manageuser.selectingToggle();
	}

	@And("Update {string} and save it")
	public void update_and_save_it(String email) {
		manageuser.updateDetails(email);
		manageuser.saveSettings();
	}

	@Then("click on pencil icon and check {string} {string} {string} is now able to select")
	public void click_on_pencil_icon_and_check_is_now_able_to_select(String brand, String country, String store)
			throws InterruptedException {
		manageuser.selectedStore(brand, country, store);
	}
}
