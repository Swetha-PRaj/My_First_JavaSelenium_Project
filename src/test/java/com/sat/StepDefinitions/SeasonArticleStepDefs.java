package com.sat.StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.sat.Pages.BookingAppLoginPage;
import com.sat.Pages.New_PromotionPage;
import com.sat.Pages.SeasonArticlePage;
import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeasonArticleStepDefs {
	public WebDriver driver;
	private Properties prop;
	private ConfigFileReader config = new ConfigFileReader();
	private SeasonArticlePage SeasonApplogin = new SeasonArticlePage(TestBase.getDriver());
	private New_PromotionPage New_Promo= new New_PromotionPage(TestBase.getDriver());
	
	@Given("Login to Admin tool App with full menu view")
    public void login_to_admin_tool_app_with_full_menu_view() throws Throwable {
		TestBase.getDriver().get(config.getApplicationUrl());
		SeasonApplogin.EnterUser(config.TestUserName());
		SeasonApplogin.EnterPass(config.TestUserPassword());
		SeasonApplogin.switchToFrame();
    }
	@When("user search {string}")
    public void cick_on_any_contact_name_link(String name) throws InterruptedException {
        try {
        	SeasonApplogin.Clickonpromoname(name);
        } catch (Exception e) {
            System.out.println("Exception :" + e + " has occurred");
        }
    }
	@Then("verify the search text {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void verify_the_task_is_routed_to(String expected_text,String value,String fYear,String fMonth,String fDate,String tYear,String tMonth,String tDate,String option,String option2,String option3,String option4,String value2) {
		SeasonApplogin.getPromoFromTheText(expected_text, value,fYear,fMonth,fDate,tYear,tMonth,tDate,option,option2,option3,option4,value2);
		//SoftAssert softassert = new SoftAssert();
        //String actualtext = SeasonApplogin.getPromoFromTheText();
        //Wait.untilPageLoadComplete(driver);
//       if(expected_text.contains(actualtext))
//        {
//         softassert.assertEquals(expected_text, actualtext);
//         System.out.println("Expected text is obtain is  "+expected_text+"  actual text obtained is "+actualtext);
//       // assertTrue(actualtext.contains(expected_text));
//        softassert.assertAll();
//        }
//   
//     else {
//    	//String ele=driver.findElement(By.xpath("//div[contains(text(),'No Promotions Found')]")).getText();
//    	//System.out.print(ele);
//    	 SeasonApplogin.ClickNewPromo();
//    	 // New_Promo.fillDetails(actualtext1);
//		System.out.println("Expected text is not obtained");
//     }
//     
      
	} 
	
	 @And("If not found click new promotion link")
	 public void If_not_found_click_new_promotion_link(){
		 SeasonApplogin.ClickNewPromo();
    	 // New_Promo.fillDetails(actualtext1);
		System.out.println("Expected text is not obtained"); 
	 }
	@And("Click on BROWSE / ADD PRODUCTS button")
    public void click_on_browse_add_products_button(){
		SeasonApplogin.clickBrowse_Product();
    }

	@And("user select Seasons from Seasons")
	    public void user_select_seasons_from_seasons(DataTable testdata) throws Throwable {
		SeasonApplogin.SeasonSelection(testdata); 
	    }

	@And("select the Divisions from Division")
	    public void select_the_divisions_from_division(DataTable testdata) throws Throwable {
		SeasonApplogin.DivisionSelection(testdata);
	    }

	@And("select the Sections from Section")
	    public void select_the_sections_from_section(DataTable testdata) throws Throwable {
		SeasonApplogin.SectionSelection(testdata);
	    }

	@And("select the Department from Departments")
	    public void select_the_department_from_departments(DataTable testdata) throws Throwable {
		SeasonApplogin.DepartmentSelection(testdata); 
	    }
	 @Then("click on search button")
	    public void click_on_search_button() throws Throwable {
		 SeasonApplogin.searchclick();
	    }

	 @Then("Navigate to Season")
	    public void Navigate_to_Season(){
			SeasonApplogin.SeasonDropDown();
	    }
	 @And("select multiple season from seasons")
	  public void select_multiple_season_from_seasons(DataTable testdata) throws InterruptedException
	  {
		 SeasonApplogin.MultipleSeason(testdata);
	  }
	 @Then("select Promotion from left Navigation")
	    public void Select_Promotion_from_left_Navigation(){
			SeasonApplogin.ClickOnPromotion();
	    }
	 @And ("Click on required Promotion")
	 public void Click_Required_Promotion() {
		 SeasonApplogin.ClickOnGivenPromotion();
	    }
	 @Then("Click on the required Promotion")
	    public void click_on_the_required_promotion_Available(){
			SeasonApplogin.ClickOnPromo();
	    }
	 @Then("click on apply button")
	    public void click_on_apply_button() throws Throwable {
		 SeasonApplogin.applyclick();
	    }
	 
	 @Then("navigate to i symbol next to item count")
		 public void navigate_to_i_symbol_next_to_item_count() throws Throwable { 
		 SeasonApplogin.iconclick();
	 }
	}
	    
   

