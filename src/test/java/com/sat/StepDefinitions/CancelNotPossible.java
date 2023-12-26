package com.sat.StepDefinitions;

import com.sat.Pages.ResalRegisterItemPage;
import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleAppNewHomeLoginPage;
import com.sat.Pages.StoreSettingsPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CancelNotPossible {


	private StoreSettingsPage storestng = new StoreSettingsPage(TestBase.getDriver());
	private ResalRegisterItemPage registerpage = new ResalRegisterItemPage(TestBase.getDriver());
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());
	private ConfigFileReader config = new ConfigFileReader();
	private ResaleAppNewHomeLoginPage resalenewhomepage = new ResaleAppNewHomeLoginPage(TestBase.getDriver());
	
	@When("Login to Resale portal tool with {string}")
	public void login_to_Resale_portal_tool_with_(String url1) {
		TestBase.getDriver().get(config.getResalePortalUrl1(url1));
	}

	@And("click on Done")
	public void click_on_Done() {
		registerpage.done();
	}

	@And("check the {string} item in available in My items tab")
	public void check_the_item_in_available_in_My_items_tab(String status) {
		registerpage.myItemsTab();
		registerpage.currentTabValidation(status);
	}

	@When("user launching ResaleApp with admin credentials and signin and selecting {string},{string},{string}")
	public void user_launching_ResaleApp_with_admin_credentials_and_signin_and_selecting(String brand, String country,
			String store) throws InterruptedException {
		resalelogin.switchTab();
		TestBase.getDriver().get(config.getResaleAppUrl());
	//manageuser.resaleAdminLogin(config.resaleAdminAppUserId(), config.resaleAdminAppPassword());
		resalelogin.switchToFrame();
		resalenewhomepage.ClickHomeResaleBackButton();
		manageuser.selectedStore(brand, country, store);
	}

	@And("sign the preregister item")
	public void sign_the_preregister_item() {
		resalelogin.itemsTab();
		resalelogin.signForPreregItem();
	}

	@And("enter {string},{string},{string} and save it")
	public void enter_and_save_it(String gender, String size, String price) throws InterruptedException {
		resalelogin.preregToInstore(gender, size, price);
	}

	@Then("swich to Portal and cancel the item which we have created")
	public void swich_to_Portal_and_cancel_the_item_which_we_have_created() {
		resalelogin.switchToParent();
		registerpage.myItemsTab();
		registerpage.cancelNotpossibleItems();
	}
	
	@Then("check the display in portal view {string} for the service and logout from booking app")
    public void check_the_display_in_portal_view_for_the_service_and_logout_from_booking_app(String enablingEle) {
        storestng.displayInPortalView(enablingEle);
        manageuser.signOut();
        TestBase.getDriver().manage().deleteAllCookies();
    }
}
