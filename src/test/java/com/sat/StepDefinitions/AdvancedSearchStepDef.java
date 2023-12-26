package com.sat.StepDefinitions;

import com.sat.Pages.AdvancedSearchPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AdvancedSearchStepDef {
		
	private AdvancedSearchPage advancedSearch = new AdvancedSearchPage(TestBase.getDriver());
	
	
	
	@And("click on the Advanced Search in All Items page")
	public void click_on_the_advanced_search_in_all_items_page() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		advancedSearch.clickOnAdvancedSearchIcon();
	}
	@Then("validate {string} in the advance search page and {string}")
	public void validate_in_the_advance_search_page(String advsrch, String advsrchtxt) {
		advancedSearch.validateAdvSrchPageTitle(advsrch, advsrchtxt);
		
	}
	@Then("validate the Key Word field {string}")
	public void validate_the_key_word_field(String keywordtext) {
		advancedSearch.validateKeyWordField(keywordtext);
	}
	@Then("validate Brand entry field and category dropdown")
	public void validate_Brand_entry_field_and_category_dropdown() {
		advancedSearch.validateBrandEntryBox();
		advancedSearch.validateCategoryDropDown();
	}
	
	@And("enter min price {string} and max price {string}")
	public void enter_min_price_and_max_price(String minprc, String maxprc) {
		advancedSearch.fillMinAndMaxPrice(minprc, maxprc);	
	}
	@Then("select the status {string}")
	public void select_the_status(String stsdrpdwn) {
		advancedSearch.clickOnStatusDropDown(stsdrpdwn);
	}
	@And("validate search and cancle button")
	public void validate_search_and_cancle_button() {
		advancedSearch.validateSearchAndCancleBtn();
	}

}
