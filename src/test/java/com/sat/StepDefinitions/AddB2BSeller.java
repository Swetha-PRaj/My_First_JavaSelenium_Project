package com.sat.StepDefinitions;

import com.sat.Pages.ResaleAppLoginPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;

public class AddB2BSeller {
	
	private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
	@And("go to {string}")
	public void go_to(String tabName) {
		resalelogin.tabSelection(tabName);
	}

	@And("click on Add B2B sller button and enter the {string} and save it")
	public void click_on_Add_B2B_sller_button_and_enter_the_and_save_it(String Name) {
		resalelogin.addB2BSeller(Name);
		//resalelogin.donePendingItem();
	}
}
