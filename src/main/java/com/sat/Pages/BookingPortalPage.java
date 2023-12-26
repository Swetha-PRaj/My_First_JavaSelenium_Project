package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.config.ConfigFileReader;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;

public class BookingPortalPage {
	String getdateformate;
	private WebDriver driver;
	private ConfigFileReader config = new ConfigFileReader();

	@FindBy(xpath = "//div[@onclick='SL.Portal.Main.selectedSlot(this)' or @onclick='SL.Portal.Resale.Main.selectedSlot(this)']")
	private List<WebElement> allEnabledSlot;

	@FindBy(xpath = "(//*[contains(@class,'form-control hasDatepicker')])[1]")
	//input[@class='form-control product-date hasDatepicker']
	//input[@class='form-control hasDatepicker']
	private WebElement getDate;

	@FindBy(xpath = "//*[text()='Next']")
	private WebElement next;

	@FindBy(name = "poname")
	private WebElement name;

	@FindBy(name = "poemail")
	private WebElement email;

	@FindBy(xpath = "//div[@class='iti__selected-flag']//div[contains(@class,'iti__flag iti__')]")
	private WebElement selectCountry;

	@FindBy(xpath = "//span[contains(text(),'India (भारत)')]")
	private WebElement selectCountryIndia;

	@FindBy(name = "pomobile")
	private WebElement mobileNumber;

	@FindBy(name = "poaddress")
	private WebElement address;

	@FindBy(name = "popostcode")
	private WebElement postCode;

	@FindBy(name = "potown")
	private WebElement city;

	@FindBy(xpath = "//button[@aria-label='Book now']//div[text()='Book now']")
	private WebElement booknowButton;

	@FindBy(xpath = "//div[@id='divselecteddate']")
	private WebElement contactpagedateformat;

	@FindBy(xpath = "//*[text()='Done']")
	private WebElement Done;

	@FindBy(xpath = "//*[text()='Hansa Malmö']")
	private WebElement validStoreName;
	// div[@id='storetarget']

	@FindBy(xpath = "//div[@id='nametarget' and contains(@class,'targets')]")
	private WebElement validName;

	@FindBy(xpath = "//div[@id='emailtarget2']")
	private WebElement validEmail;

	@FindBy(xpath = "//div[@id='phonetarget']")
	private WebElement validPhoneNo;

	@FindBy(xpath = "//div[@id='addresstarget']")
	private WebElement validaddress;

	@FindBy(xpath = "//div[text()='How it works?:']")
	private WebElement howItWorksText;

	@FindBy(xpath = "//div[@class='row rowquestions']//*[contains(text(),'Have questions?')]")
	private WebElement brandmail;

	@FindBy(xpath = "//div[@class='cancelledBooking']//*[contains(text(),'Have questions?')]")
	private WebElement brandMailInCancelled;

	@FindBy(xpath = "//*[text()='Cancel booking']")
	private WebElement cancleBooking;

	@FindBy(xpath = "//*[text()='Yes']")
	private WebElement Yesbtn;

	@FindBy(xpath = "//*[text()='No']")
	private WebElement Nobtn;

	@FindBy(xpath = "//*[text()='Your booking has been cancelled']")
	private WebElement bookingCancleMsg;

	@FindBy(xpath = "//*[@id='from']")
	private WebElement gettingDate;

	@FindBy(xpath = "//*[@class='ui-datepicker-month']")
	private WebElement month;

	@FindBy(xpath = "//*[@class='ui-datepicker-year']")
	private WebElement year;

	@FindBy(xpath = "//*[@class='col-xs-11 nopadding']//*[@class='form-control hasDatepicker']")
	private WebElement gettingDate1;

	@FindBy(xpath = "//*[@class='ui-icon ui-icon-circle-triangle-e']")
	private WebElement calendarNextbtn;

	@FindBy(xpath = "//div[@id='datetarget' and @class='targets']")
	private WebElement bookingDetailsDate;

	@FindBy(xpath = "//div[text()='Back to My profile' and @class='xrm-attribute-value']")
	private WebElement backToMyProfilebtn;

	@FindBy(xpath = "//button[@data-bind=\"visible: !SL.Portal.Resale.Main.isNewEntry()\"]//div[@class='xrm-editable-html xrm-attribute']//div[text()='Cancel']")
	private WebElement resaleBookingCancle;

	Wait waits = new Wait();
	Testutil util = new Testutil();
	Testutil testutil = new Testutil();
	public BookingPortalPage(WebDriver driver) {
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
	//check the store is available in the home page and click on it
	public void checkStoreAndClickOnIt(String storeName) {
		WebElement checkingStore = driver.findElement(By.xpath("//*[contains(text(),'" + storeName + "')]"));
		if (checkingStore.isDisplayed()) {
			checkingStore.click();
			System.out.println(driver.getTitle());
		} else {
			System.out.println("store is not available");
		}
	}
	// validate the date formate in the slot booking page
	public void validateDateFormat() throws InterruptedException {
		System.out.println("started validating");
		Thread.sleep(3000);
		//Wait.waitUntilElementVisible(driver, gettingDate);
		Wait.elementToBeClickable(driver, gettingDate, 2);
		Wait.waitUntilElementVisible(driver, gettingDate);

		// find the element in selenium webdriver
		//WebElement userNameTxt = gettingDate;
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// set the text
		// jsExecutor.executeScript("arguments[0].value='testuser'", userNameTxt);
		// get the text
		String bookingPortaldate = (String) jsExecutor.executeScript("return arguments[0].value", gettingDate);
		System.out.println("Portal date" + bookingPortaldate);

		// String dateforamt = gettingDate.getText();
		// System.out.println(dateforamt);
		// String dateformat1 = gettingDate1.getAttribute("text");
		// System.out.println(dateformat1 + "attribute");
		Date date = new Date();
		// System.out.println(date);
		String[] weekday = bookingPortaldate.split(",");
		System.out.println("splited data" + weekday[0]);
		String date1 = weekday[0];
		if(date1.length() == 3) {
			SimpleDateFormat formatter = new SimpleDateFormat("E, MMMMMMMMM d, yyyy");
			String strDate = formatter.format(date);
			// System.out.println("Date Format with E, MMMM dd, yyyy : "+strDate);
			System.out.println(strDate);
			assertTrue(strDate.contains(bookingPortaldate), "Time formate is not as expected");
		}else {
			SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMMMMMMM d, yyyy");
			String strDate = formatter.format(date);
			// System.out.println("Date Format with E, MMMM dd, yyyy : "+strDate);
			System.out.println(strDate);
			assertTrue(strDate.contains(bookingPortaldate), "Time formate is not as expected");
		}
		System.out.println("completed validation");
		/*Wed, August 9, 2022 --- portal
		Wed, August 09, 2022 --- formater
		/?[0-9]*/

	}
	//select the date of booking
	public void selectSlotDate(String setMonth, String setYear, String setDate) {
		gettingDate.click();
		String month1 = month.getText();
		if(!month1.equals(setMonth)) {
			calendarNextbtn.click();
		}
		//month.sendKeys(setMonth, Keys.ENTER);
		//year.sendKeys(setYear, Keys.ENTER);
		WebElement date = driver.findElement(By.xpath("//*[contains(@class,'ui-state-default') and text()='"+setDate+"']"));
		date.click();
	}
	//check the enabled slot and select it
	public void checkEnabledSlotAndClickOnIt(String bookingSlotTime) {
		//getdateformate = getDate.getText();
		List<WebElement> slotTime = driver.findElements(
				By.xpath("//div[(@onclick='SL.Portal.Resale.Main.selectedSlot(this)' and text()='"+bookingSlotTime+"') or (@onclick='SL.Portal.Main.selectedSlot(this)' and text()='"+bookingSlotTime+"')]"));
		if (!slotTime.isEmpty()) {
			System.out.println(bookingSlotTime);
			Wait.elementToBeClickable(driver, slotTime.get(0), 10);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Wait.elementToBeClickable(driver, slotTime.get(0), 10);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			slotTime.get(0).click();
			next.click();
		}
		else {
			System.out.println(bookingSlotTime + " is disabled so executing else block");
			List<WebElement> listOfSlots = allEnabledSlot;
			System.out.println(listOfSlots);
			for (int i = 0; i < listOfSlots.size(); i++) {
				System.out.println(listOfSlots.get(i));
				if (listOfSlots.get(i).isEnabled()) {
					System.out.println(listOfSlots.get(i) + " is enabled");
					System.out.println("clicking on ");
					listOfSlots.get(i).click();
					next.click();
					break;
				} else {
					System.out.println(listOfSlots.get(i).getText() + " is disabled");

				}
			}
		}
	}
	// enter the contact details in the contact page
	public void enterContactDetails(String contactName, String contactEmail, String contactMobile,
			String contactAddress, String contactPostcode, String contactCity) {
		String contdateformat = contactpagedateformat.getText();
		// assert.assertTrue(getdateformate.equals(contdateformat), "date formate of
		// main page and contact page is not same");
		//if (getdateformate.equals(contdateformat)) {
		//	System.out.println("both date format is same" + getdateformate + " " + contdateformat);
		//} else {
		//	System.out.println("both date format are different" + getdateformate + " " + contdateformat);
		//}
		name.click();
		name.sendKeys(contactName);
		email.click();
		email.sendKeys(contactEmail);
		selectCountry.click();
		Wait.elementToBeClickable(driver, selectCountryIndia, 3);
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", selectCountryIndia);
		selectCountryIndia.click();
		Wait.elementToBeClickable(driver, mobileNumber, 3);
		mobileNumber.click();
		mobileNumber.sendKeys(contactMobile);
		address.click();
		address.sendKeys(contactAddress);
		postCode.click();
		postCode.sendKeys(contactPostcode);
		city.click();
		city.sendKeys(contactCity);
		booknowButton.click();

	}
	//validate the contact page 
	public void validateContactDetails(String Name, String Email, String phoneno, String address, String helpmail) {
		//Wait.waitUntilElementVisible(driver, validStoreName);
		//String validStoreName1 = validStoreName.getText();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String validName1 = validName.getText();
		String validEmail1 = validEmail.getText();
		String validPhoneNo1 = validPhoneNo.getText();
		String validaddress1 = validaddress.getText();
		//String howItWorks = howItWorksText.getText();
		//String haveQuestions = brandmail.getText();

		//System.out.println(haveQuestions);
		//System.out.println(validStoreName1);
		System.out.println(validName1);
		System.out.println(validEmail1);
		System.out.println(validPhoneNo1);
		System.out.println(validaddress1);
		//System.out.println(howItWorks);

		//assertTrue(haveQuestions.contains(helpmail), "Conatact Email is not same");
		assertTrue(validName1.contains(Name), "Conatact Name is not same");
		assertTrue(validName1.contains(Name), "Conatact Name is not same");
		assertTrue(validEmail1.contains(Email), "Conatact Email is not same");
		assertTrue(validPhoneNo1.contains(phoneno), "Conatact Phone is not same");
		assertTrue(validaddress1.contains(address), "Conatact address is not same");

	}
	public void validateConfirmationExtendButton() throws ElementNotVisibleException
	{
		if(driver.findElement(By.xpath("(//div[@class='xrm-attribute-value'][normalize-space()='Confirmation'])[1]")).isDisplayed()) 
		{
			System.out.println("Confirmation page is present by getting text from page as : "+driver.findElement(By.xpath("(//div[@class='xrm-attribute-value'][normalize-space()='Confirmation'])[1]")).getText() );
		}

		else
		{
			System.out.println("Confirmation page is not there");
		}
		/*
		   List<WebElement> resultList = driver.findElements(By.xpath("//div[contains(text(),'Cancel booking')]"));

		   if(resultList.size() > 0){
			   System.out.println("Extend Button is present");
		   }
			   else
			   {
		       System.out.println("Show more is not there");
		   }
		 */
		Boolean check = check_Extend_booking_button_visible();
		if(check)
		{
			System.out.println("Extend Button is present in page");
		}

		else
		{
			System.out.println("Extend Button is not there");
		}

	}

	public boolean check_Extend_booking_button_visible()
	{
		try
		{ 	WebElement extend =driver.findElement(By.xpath("//div[contains(text(),'Extend Booking')]"));
		System.out.println(extend.getAttribute("innerText"));
		WebElement button = driver.findElement(By.xpath("//div[contains(text(),'Extend Booking')]")); 
		Assert.assertEquals(true, button.isDisplayed());

		if(button.isDisplayed())
		{ 		
			return true; 
		} 	
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{ 			
			System.out.println("Element not found"); 	
			return false; 	
		}
		return false;
	}
	public void validateFromResaleBookingdeails(String storeName, String date, String month, String year, String Name, String Email) {
		Wait.waitUntilElementVisible(driver, validName);
		WebElement store = driver.findElement(By.xpath("//div[@class='targets' and contains(text(),'"+storeName+"')]"));
		String store1 = store.getText();
		assertTrue(store1.contains(storeName), "StoreName is not updated in booking details");

		String date1 = bookingDetailsDate.getText();
		assertTrue(date1.contains(date), "Date is not updated in booking details");
		assertTrue(date1.contains(month), "month is not updated in booking details");
		assertTrue(date1.contains(year), "year is not updated in booking details");

		String validName1 = validName.getText();
		String validEmail1 = validEmail.getText();
		assertTrue(validName1.contains(Name), "Conatact Name is not same");
		assertTrue(validEmail1.contains(config.getResalePortaluserId(Email)), "Conatact Email is not same");

		String btn = backToMyProfilebtn.getText();
		assertTrue(btn.contains("Back to My profile"), "Back to My profile is not available in the page");
	}

	public void validateRegisteredItems(String brandName, String CategoryName) {
		//Wait.waitUntilElementVisible(driver, validName);
		//String brandName1 = brandName.toLowerCase();
		//System.out.println(brandName1 +"converted to lower case");
		WebElement brand = driver.findElement(By.xpath("//div[@class='col-xs-11 getregitem' and text()='"+brandName+"']"));
		String brand1 = brand.getText();
		System.out.println(brand1 + "text taken from booking details");
		assertTrue(brand1.contains(brandName), "BrandName is not updated in Registered Items");

		Wait.waitUntilElementVisible(driver, validName);
		WebElement Category = driver.findElement(By.xpath("//div[@class='col-xs-11 getregitem']//*[text()='"+CategoryName+"']"));
		String Category1 = Category.getText();
		System.out.println(CategoryName +" from feature file");
		System.out.println(Category1 + "text taken from booking details");
		assertTrue(Category1.contains(CategoryName), "CategoryName is not updated in Registered Items");

	}

	public void clickOnDone() {
		//Done.click();
		Boolean flag = false;
		while (!flag) {
			System.out.println("need to click on the store");
			List<WebElement> ele = driver.findElements(By.xpath("//*[text()='Done']"));
			System.out.println("clicked on the store");
			for (int i = 0; i < ele.size(); i++)

			{
				if (isClickable(ele.get(i))) {
					ele.get(i).click();
					flag = true;
					i = ele.size();
				}
			}
		}
	}

	public void cancleBooking() {
		cancleBooking.click();
	}

	public void clickOnYesbtnAndVerifyMsg(String helpmail) {
		Yesbtn.click();
		Wait.waitUntilElementVisible(driver, bookingCancleMsg);
		//String string1 = brandMailInCancelled.getText();
		//assertTrue(bookingCancleMsg.isDisplayed(), "booking cancle message is not displayed");
		//assertTrue(string1.contains(helpmail), "Conatact Email is not same");
	}

	public void clickOnNo() {
		Nobtn.click();
	}
	public void clickOnCancle() {
		resaleBookingCancle.click();
		//util.actionMethodClick(driver, resaleBookingCancle);
		System.out.println(driver.getTitle());
		String portal_title = driver.getTitle();
		assertTrue(portal_title.equalsIgnoreCase("Resale"), "page is not landed in resale portal");
		Yesbtn.click();

	}
	public void Click_ResalePortal_Done() {
		List<WebElement> buttons=driver.findElements(By.xpath("//div[@id='regitems']/following-sibling::div[@class='row']//button//div//div[text()='Done']"));
		assertTrue(buttons.size()>0,"Done Button is not displayed");
	}
}