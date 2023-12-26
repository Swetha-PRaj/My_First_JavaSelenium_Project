package com.sat.Pages;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

public class New_PromotionPage {
	private StoreCalendarsPage StoreCalendars = new StoreCalendarsPage(TestBase.getDriver());
	
	private WebDriver driver;
	Testutil testutil = new Testutil();
	
	public New_PromotionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'NEW PROMOTION')]")
	private WebElement Newpromo;
	 
	@FindBy(xpath="//input[contains(@aria-label,'txtNewPromotionTitlePLS')]")
	 private WebElement Promotitle;
	@FindBy(xpath="//input[contains(@aria-label,'txtNewDiscountPLS')][1]")
	private WebElement Discounttxt;
	
	@FindBy(xpath="(//div[contains(@class,'combobox-view-chevron arrowContainer_1kmq8gc-o_O-container_r2h174-o_O-containerColors_3aikec')])[1]")
	private WebElement storedropdown;
	
	@FindBy(xpath="(//div[contains(@class,'combobox-view-chevron arrowContainer_1kmq8gc-o_O-container_r2h174-o_O-containerColors_3aikec')])[2]")
	private WebElement customerdropdown;
	@FindBy(xpath="(//div[contains(@class,'combobox-view-chevron arrowContainer_1kmq8gc-o_O-container_r2h174-o_O-containerColors_3aikec')])[3]")
	private WebElement seasondropdown;
	@FindBy(xpath="(//div[contains(@class,'combobox-view-chevron arrowContainer_1kmq8gc-o_O-container_r2h174-o_O-containerColors_3aikec')])[4]")
	private WebElement ProTypedropdown;
	@FindBy(xpath="(//div[contains(@class,'combobox-view-chevron arrowContainer_1kmq8gc-o_O-container_r2h174-o_O-containerColors_3aikec')])[5]")
	private WebElement Typedropdown;
	
	@FindBy(xpath ="//input[@placeholder='Start date *']")
	private WebElement openCalendar;
	@FindBy(xpath = "//select[@class='pika-select pika-select-year']")
	private WebElement selectYear;
	@FindBy(xpath = "//select[@class='pika-select pika-select-month']")
	private WebElement selectMonth;
	
	@FindBy(xpath = "//input[@placeholder='End date *']")
	private WebElement opentoCalendar;
	@FindBy(xpath = "(//select[@class='pika-select pika-select-year'])[2]")
	private WebElement selecttoYear;
	@FindBy(xpath = "(//select[@class='pika-select pika-select-month'])[2]")
	private WebElement selecttoMonth;
	@FindBy(xpath = "//button[text()='Ok']")
	private WebElement okfmBtn;
	@FindBy(xpath = "//button[text()='Ok']")
	private WebElement oktoBtn;
	
	@FindBy(xpath="//div[contains(text(),'SAVE')]")
	private WebElement SAVE;		
	
	 public void ClickPromo()
     {
 		testutil.actionMethodClick(driver, Newpromo);
 		testutil.jsclick(driver, Newpromo);
 		
     }
	
	 public void fillDetails(String value) {
	
		 Promotitle.sendKeys(value);
		 //driver.findElement(By.xpath("//input[contains(@aria-label,'txtNewPromotionTitlePLS')]")).sendKeys("001Demo");
		 Discounttxt.sendKeys(value);		  
		 }
	 public void selectCalFromDate( String fmYear, String fmMonth,String fmDate) {
		 
		 System.out.println("click on from date");
		 //testutil.actionMethodClick(driver, openCalendar);
		// Wait.elementToBeClickable(driver, openCalendar, 2);
		 openCalendar.click();
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 testutil.actionMethodClick(driver, selectYear);
			selectYear.sendKeys(fmYear, Keys.ENTER);
			Wait.elementToBeClickable(driver, selectMonth, 3);
			selectMonth.click();
			//testutil.actionMethodClick(driver, selectMonth);
			selectMonth.sendKeys(fmMonth, Keys.ENTER);
			WebElement dateVal = driver
					.findElement(By.xpath("//button[@class='pika-button pika-day' and  @data-pika-day  ='" + fmDate + "']"));
			dateVal.click();
			 Wait.elementToBeClickable(driver, okfmBtn, 2);
			 okfmBtn.click();
	 }
 
	 public void selectCalToDate(String tYear, String tMonth,String tDate) {	 
			 System.out.println("click on to date");
				//Wait.elementToBeClickable(driver, opentoCalendar, 2);
			 System.out.println("click on from date");
			 //testutil.actionMethodClick(driver, openCalendar);
			// Wait.elementToBeClickable(driver, openCalendar, 2);
			 opentoCalendar.click();
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 selecttoYear.click();
			 //JavascriptExecutor executor = (JavascriptExecutor) driver;
			 //executor.executeScript("arguments[0].scrollIntoView(true);", selecttoYear);    
			//selecttoYear.click();
			// selecttoYear.click();
			 //testutil.actionMethodClick(driver, selecttoYear);
			 selecttoYear.sendKeys(tYear, Keys.ENTER);
				Wait.elementToBeClickable(driver, selecttoMonth, 3);
				selecttoMonth.click();
				//testutil.actionMethodClick(driver, selectMonth);
				selecttoMonth.sendKeys(tMonth, Keys.ENTER);
				WebElement dateVal = driver
						.findElement(By.xpath("(//button[@class='pika-button pika-day' and  @data-pika-day  ='" + tDate + "'])[2]"));
				dateVal.click();
				 Wait.elementToBeClickable(driver, oktoBtn, 2);
				 //oktoBtn.click();
				StoreCalendars.clickOnOk();
		}
	 public void clickonDropdownAll() {
		 storedropdown.click();
	    }
	 public void clickonDropdownCustomer() {
		 customerdropdown.click();
	    }
	 public void clickonDropdownSeason() {
		 seasondropdown.click();
	    }
	 public void clickonDropdownProType() {
		 ProTypedropdown.click();
	    }
	 public void clickonDropdownType() {
		 Typedropdown.click();
	    }
	 
	 public void clickonAll(String option) {
	       // Wait.untilPageLoadComplete(driver,300);
	        Wait.elementToBeClickable(driver, driver.findElement(By.xpath("//*[text()='" + option + "']")), 300);
	        // Wait.untilPageLoadComplete(driver,300);
	        driver.findElement(By.xpath("//*[text()='" + option +"']")).click();
	        //neha
	   }
	 public void clickonProType() {
	       // Wait.untilPageLoadComplete(driver,300);
	        Wait.elementToBeClickable(driver, driver.findElement(By.xpath("//span[@class='itemTemplateLabel_dqr75c']")), 300);
	        // Wait.untilPageLoadComplete(driver,300);
	        driver.findElement(By.xpath("//span[@class='itemTemplateLabel_dqr75c']")).click();
	        //neha
	   }
	 public void clickonSAVE() {
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeScript("arguments[0].scrollIntoView(true);", SAVE); 
		 SAVE.click();
	 }
	 
	 }
	 
	