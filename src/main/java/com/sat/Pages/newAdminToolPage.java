package com.sat.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Log;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;

public class newAdminToolPage {
	String getdateformate;
	private WebDriver driver;
	private ConfigFileReader config = new ConfigFileReader();
	Testutil util = new Testutil();
	Testutil testutil = new Testutil();
	@FindBy(xpath = "//div[@onclick='SL.Portal.Main.selectedSlot(this)' or @onclick='SL.Portal.Resale.Main.selectedSlot(this)']")
	private List<WebElement> allEnabledSlot;

	@FindBy(xpath = "//div[contains(text(),'Personal shopper access')]")
	private WebElement confirmation_msg;
     
	@FindBy(xpath = "//div[@class='appmagic-button-label no-focus-outline' and text()='ADD']")
	private WebElement addbtn;
	
	@FindBy(xpath = "//input[@placeholder='Search for email' and @appmagic-control='txtSearchPersonalShopertextbox']")
	private WebElement ShoppertxtField;
	
	
	@FindBy(xpath = "//*[name()='polygon' and contains(@class,'checkmark')]")
	private WebElement Shopperchk;
	
	@FindBy(xpath = "//*[@id='toast-container']")
	private List<WebElement> toasteContainer;
	//span[contains(text(),'User was succesfully added to Personal shopper access')]
	//*[text()='Service added successfully']
	@FindBy(xpath = "//*[text()='User was succesfully added to Personal shopper access']")
	private List<WebElement> ShopperAddedMsg;
	@FindBy(xpath = "//*[text()='User was succesfully removed from Personal shopper access']")
	private List<WebElement> ShopperRemoveMsg;
	
	//div[contains(text(),'Remove')]
	@FindBy(xpath = "//div[contains(text(),'Remove')]")
	private WebElement removebtn;

	public newAdminToolPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean isClickable(WebElement ele) {
		boolean flag = true;
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(ele));
			System.out.println("Element is clickable");
		} catch (Exception e) {
			System.out.println("Element isn't clickable");
			flag = false;
		}
		return flag;
	}
	public void validateSuccessMessageAdmin() {
		String actual = confirmation_msg.getText();
		System.out.println("The Actual String:"+actual);
		String expected = "Personal shopper access";
		System.out.println("The expected String:"+expected);
		// Assert.assertEquals(actual, expected);
		if (expected.equals(actual)) {
			System.out.println("Both Actual and Expected strings are equal");
		} else {
			System.out.println("Both Actual and Expected strings are not equal");
		}
	}

	public void scrollDownToShopper()
    {
        try {Wait.untilPageLoadComplete(driver,200);
        Boolean flag = false;
		while (!flag) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> personalShopper = driver.findElements(By.xpath("//*[@title='Personal Shopper']"));	
			System.out.println(personalShopper);
			for (int i = 0; i < personalShopper.size(); i++){
				if (isClickable(personalShopper.get(i))) {
					// ele.get(i).click();
					Wait.elementToBeClickable(driver, personalShopper.get(i), 5);
					System.out.println(personalShopper.get(i));
					util.actionMethodClick(driver, personalShopper.get(i));
					flag = true;
					i = personalShopper.size();
				}
			}
        Wait.untilPageLoadComplete(driver,200);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);
    }}catch(Exception e) {};
        }
	
	public void ClickAdd()
	{
		Wait.elementToBeClickable(driver, addbtn, 5);
		try{
			addbtn.click();
		}catch(Exception e) {
			util.actionMethodClick(driver, addbtn);
		}
		
	}
	public void waitForVisible(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(1000);
			System.out.println("Waiting for element visibility - wait for visible");
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SearchShopper(String ShopperID)
	{
		
			waitForVisible(driver, ShoppertxtField);
			Actions actions = new Actions(driver);
			actions.moveToElement(ShoppertxtField);
			actions.click();
			Wait.textToBePresent(driver, ShoppertxtField, ShopperID, 3);
			actions.sendKeys(ShopperID + Keys.ENTER);
			actions.build().perform();
			Log.info("entered shopper ID");
			System.out.println("Shopper email Id entered");
			
			
			Wait.elementToBeClickable(driver, Shopperchk, 2);
			util.actionMethodClick(driver, Shopperchk);
			System.out.println("Click on the shopper checkbox");
			
			Boolean flag = false;
			while (!flag) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<WebElement> ShopperAddBtn = driver.findElements(By.xpath("//div[@data-control-name='btnAddMIS']//div[@class='appmagic-button-label no-focus-outline']"));	
				System.out.println(ShopperAddBtn);
				for (int i = 0; i < ShopperAddBtn.size(); i++){
					if (isClickable(ShopperAddBtn.get(i))) {
						// ele.get(i).click();
						Wait.elementToBeClickable(driver, ShopperAddBtn.get(i), 5);
						System.out.println(ShopperAddBtn.get(i));
						util.actionMethodClick(driver, ShopperAddBtn.get(i));
						flag = true;
						i = ShopperAddBtn.size();
					}
				}
				System.out.println("Clicked On ADD button after chk box");
		
			//String message = driver.findElement(By.xpath("//span[contains(text(),'User was succesfully added to Personal shopper access')]")).getText();
			//System.out.println(message);
			//WebElement popmsg =driver.findElement(By.xpath("//span[contains(text(),'User was succesfully added to Personal shopper access')]"));
			//WebDriverWait wait = new WebDriverWait(driver, 120);
			//wait.until(ExpectedConditions.invisibilityOf(popmsg));
			//String expectedMessage = "User was succesfully added to Personal shopper access";
			//String message = driver.findElement(By.xpath("//span[contains(text(),'User was succesfully added to Personal shopper access')]")).getText();
		//(expectedMessage,message );
		//assertEquals(expectedMessage, message);
		//testutil.validatesuccessmsg(driver, popmsg, toasteContainer);
	}
	}
			public void validateShopperAddedMsg() {
				// List<WebElement> we =
				// driver.findElements(By.xpath("//*[text()='"+Successmsg+"']"));
				testutil.validatesuccessmsg(driver, ShopperAddedMsg, toasteContainer);
			}
			
			public boolean isElementPresent( String existingShopperName ) {
				System.out.println("Element present in isElementPresent");
		        boolean isPresent = false;
		        List<WebElement>  allInputElements = driver.findElements(By.xpath("//div[text()='" + existingShopperName + "']/parent::div"));
		        System.out.println(allInputElements.size());
		        // Search for elements and check if list is empty
		        if (allInputElements.size()!=0) {
		        	System.out.println(allInputElements.size() + " Elements found by TagName as input \n");
		            isPresent = true;
		            for(WebElement inputElement : allInputElements) 
					   {
		            	System.out.println(inputElement.getText());
		            	//System.out.println(inputElement.getAttribute("data-control-name"));
					   }
		        }
		        // Rise back implicitly wait time
		       
		        return isPresent;
		    }
			
			public void RemoveShopper(String existingUserName , String shopperName)
			{
				System.out.println("Element present in CliclDots");
			 Boolean isShopperPresent=	isElementPresent(existingUserName);
			 if(isShopperPresent==true)
			 {
				 System.out.println("Shopper is Present in the list, now remove the access");
				 System.out.println("about to click on Remove dots");
				WebElement dots = driver.findElement(By.xpath("//div[text()='" + shopperName + "']/parent::div//ancestor::div[contains(@data-control-name,'lblGalleryFirstName')]/following-sibling::div"));
				 util.actionMethodClick(driver, dots);
				 dots.click();
				 removebtn.click();
			
				 WebElement yes = driver.findElement(By.xpath("//div[contains(text(),'YES')]"));
					util.actionMethodClick(driver, yes);
			 }			}
			public void validateShopperRemoveMsg() {
				// List<WebElement> we =
				// driver.findElements(By.xpath("//*[text()='"+Successmsg+"']"));
				testutil.validatesuccessmsg(driver, ShopperRemoveMsg, toasteContainer);
			}
}
	



