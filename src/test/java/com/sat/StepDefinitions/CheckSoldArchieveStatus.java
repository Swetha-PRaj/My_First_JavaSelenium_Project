
package com.sat.StepDefinitions;

import com.sat.Pages.PowerAppsAutomateFlowPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CheckSoldArchieveStatus {
	
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	private PowerAppsAutomateFlowPage job = new PowerAppsAutomateFlowPage(TestBase.getDriver());
	private ConfigFileReader config = new ConfigFileReader();

	@And("open the created item {string} to {string}")
	public void open_the_created_item_to(String status, String updatedStatus) throws InterruptedException {
		resalelogin.itemsTab();
		resalelogin.openItem(status);
		resalelogin.updateStatusFrmDropdown(updatedStatus);
		resalelogin.uploadImageInItemPage();
		resalelogin.pendingSave();
		//resalelogin.donePendingItem();
	}
	@Then("change the status from {string} to {string}")
	public void change_the_status_from_to(String status, String updatedStatus) {
		resalelogin.changeStatusOfItem(status,updatedStatus);
	}
	@Then("Validate the mail {string}")
	public void validate_the_mail(String emailSubject) {
		resalelogin.switchTab();
		TestBase.getDriver().get(config.getEmailUrl());
		
		//gmailLoginPage.ValidationWithoutPromotionTab(emailSubject);
		resalelogin.switchToOriginal();
	}
	@Then("check the status {string}")
	public void check_the_status(String status) throws InterruptedException {

		resalelogin.itemsTab();
		resalelogin.validateStatusOfItem(status);
		//resalelogin.openItem(status);
		//resalelogin.displayStatus(status);
		//resalelogin.pendingSave();
	}

	@And("run the job {string}")
	public void run_the_job(String flowName) {
		resalelogin.switchTab();
		TestBase.getDriver().get(config.getPowerAppCloudFlow());
		job.runCloudFlow(flowName);
		resalelogin.switchToOriginal();
	}
	@And("click on refresh button")
	public void click_on_refresh_button() {
		resalelogin.refresh();
		//resalelogin.refreshRightSideScreen();
	}

	@Then("open the created item {string} and check the status")
	public void open_the_created_item_and_check_the(String status) throws InterruptedException {
		//resalelogin.selectExistingSeller(existingSeller, tabSelection);
		resalelogin.itemsTab();
		resalelogin.validateStatusOfItem(status);
		resalelogin.openItem(status);
		resalelogin.displayStatus(status);
		resalelogin.pendingSave();
	}
}
