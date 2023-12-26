package com.sat.StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sat.Pages.ResaleAdminPage;
import com.sat.Pages.ResaleAppLoginPage;
import com.sat.Pages.ResaleLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class Resaleportalloginenter {

		public WebDriver driver;

		private ResaleLoginPage resalregister = new ResaleLoginPage(TestBase.getDriver());
		private ResaleAppLoginPage resalelogin = new ResaleAppLoginPage(TestBase.getDriver());
		private ResaleLoginPage resalepagelogin = new ResaleLoginPage(TestBase.getDriver());
		private ResaleAdminPage manageuser = new ResaleAdminPage(TestBase.getDriver());

		private Properties prop;
		private ConfigFileReader config = new ConfigFileReader();	
		@Given("user go to login page {string}" )
		public void user_go_to_login_page(String url1) {
			TestBase.getDriver().get(config.getResalePortalUrl1(url1));
			//resalregister.createAccount();
		}
		@And("user enters valid ResalePortal {string} and {string} Resale")
		public void user_enters_valid_ResalePortal_and_Resale(String user1, String password) throws InterruptedException {
			resalepagelogin.loginResalePortal(config.getResalePortaluserId(user1),
					config.getResalePortalpassword(password));
			resalepagelogin.Enterpassword_byEnter();
			//input[@id='popassword']
			
			 //textbox.sendKeys(Keys.ENTER);
		
			        
			        
		}

	}

