package com.sat.Pages;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;

public class SeasonArticlePage {
	private WebDriver driver;
	Testutil testutil = new Testutil();
	private New_PromotionPage New_Promo= new New_PromotionPage(TestBase.getDriver());
	@FindBy(xpath = "//input[@name='loginfmt']")
	private WebElement UserName;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement NextButton;
	//input[@type='password']
	@FindBy(xpath = "//*[@type='password']")
	private WebElement Password;

	@FindBy(xpath = "//*[@id='idSIButton9']") // *[@type='submit']
	private WebElement Signin;
	
	@FindBy(xpath = "//div[@data-control-name='icnProductInfoPS'][1]") // *[@type='submit']
	private WebElement icon;

	@FindBy(xpath = "//*[@name='DontShowAgain']")
	private WebElement DontShowAgain;

	@FindBy(xpath = "//*[@id='idSIButton9']")
	private WebElement Yes;

	@FindBy(xpath = "//input[@placeholder='Select Season*']")
	private WebElement seasonlist;

	@FindBy(xpath="//div[contains(text(),'NEW PROMOTION')]")
	private WebElement Newpromo;

	@FindBy(xpath="//div[contains(text(),'SEARCH')]")
	private WebElement searchbtn;
	
	@FindBy(xpath="//div[@data-control-name='btnGoFiltersPS']//div[@class='appmagic-button middle center']")
	private WebElement applybtn;
	
	private WebElement penIcon;
	private By penIcon1 = By.xpath(("//div[@data-control-name='icnEditCountrySelect']//div[@class='powerapps-icon no-focus-outline']"));

	public static Map<String, String> Seasonstatus = new HashMap<>();

	public SeasonArticlePage(WebDriver driver) {
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


	public void EnterUser(String userId) {
		UserName.click();
		UserName.sendKeys(userId);
		//NextButton.click();
		testutil.actionMethodClick(driver, NextButton);
	}
	public void ClickNewPromo()
	{
		//testutil.actionMethodClick(driver, Newpromo);
		//testutil.jsclick(driver, Newpromo);
		New_Promo.ClickPromo();

		//New_Promo.selectCalFromDate(getPromoFromTheText(), getPromoFromTheText(), getPromoFromTheText());

	}

	public void EnterPass(String userPassword) {
		Wait.untilPageLoadComplete(driver, 5);
		Wait.elementToBeClickable(driver, Password, 5);
		Password.click();
		Password.sendKeys(userPassword);
		Wait.elementToBeClickable(driver, Signin, 5);
		Wait.untilPageLoadComplete(driver, 5);
		Wait.waitUntilElementVisible(driver, Signin);
		Wait.elementToBeClickable(driver, Signin, 5);
		Signin.click();
		//testutil.actionMethodClick(driver, Signin);
		// Wait.waitUntilElementVisible(driver, DontShowAgain);
		// DontShowAgain.click();
		// Yes.click();
		System.out.println("logged in");
		Wait.untilPageLoadComplete(driver);
		//driver.switchTo().frame("fullscreen-app-host");
	}
	public void switchToFrame() {
		driver.switchTo().frame("fullscreen-app-host");
	}

	public void Clickonpromoname(String name) throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name, Keys.ENTER);
		Wait.untilPageLoadComplete(driver);   

	}
	public void getPromoFromTheText(String expected_text, String value,String fYear,String fMonth,String fDate,String tYear, String tMonth,String tDate,String option,String option2,String option3,String option4, String value2) {
		List<WebElement> ele = driver.findElements(By.xpath("//*[text()='Automation Demo']/parent::div/div[1]"));
		System.out.println(ele.size());
		//String e1 = null;
		for(int i=0; i <=ele.size(); i++) {
			if(ele.size()!=0) {
				//System.out.println("Actual text matches with Expected text");
				String actualtext = ele.get(0).getText();
				System.out.println("Actual text = "+actualtext +"matches with Expected text ="+expected_text);
				assertTrue(actualtext.contains(expected_text), expected_text +" is not in the list of promition");

			}
			else {
				System.out.println("Inside Else block");
				System.out.println("No Promotion found so creating new promotion");
				ClickNewPromo();
				New_Promo.fillDetails(value);
				//fmcalender
				New_Promo.selectCalFromDate(fYear,fMonth,fDate);
				New_Promo.selectCalToDate(tYear, tMonth, tDate);
				New_Promo.clickonDropdownAll();
				New_Promo.clickonAll(option);
				New_Promo.clickonDropdownCustomer();
				New_Promo.clickonAll(option2);
				New_Promo.clickonDropdownSeason();
				New_Promo.clickonAll(option3);
				New_Promo.clickonDropdownType();
				New_Promo.clickonAll(option4);
				New_Promo.clickonDropdownProType();
				New_Promo.clickonProType();
				New_Promo.fillDetails(value2);
				New_Promo.clickonSAVE();
				
			}
		}
	}

	public void ClickOnPromo() {
		WebElement clickpro = driver.findElement(By.xpath("(//div[@data-control-name=\"icnPromotionNamePLS\"])[1]"));
		if (clickpro.isDisplayed()) {
			clickpro.click();
			System.out.println(driver.getTitle());
		} else {
			System.out.println("store is not available");
		}
	}

	public void clickBrowse_Product() {
		//Wait.elementToBeClickable(driver, browsers, 5);
		System.out.println("Clicking on Browser");
		WebElement str=	driver.findElement(By.xpath("//div[@data-control-name='btnBrowseInventoryPPS']//div[text()='BROWSE / ADD PRODUCTS']"));
		System.out.println("Using JsClick");
		testutil.jsclick(driver, str);
		System.out.println("Using ActionClick");
		testutil.actionMethodClick(driver, str);
		//System.out.println("Click");
		//str.click();
		/*Boolean flag = false;
				while (!flag) {
					List<WebElement> ele = driver.findElements(By.xpath("//div[@data-control-name='btnBrowseInventoryPPS']//div[text()='BROWSE / ADD PRODUCTS']"));
					System.out.println(ele);
					for (int i = 0; i < ele.size(); i++)

					{
						if (isClickable(ele.get(i))) {
							// ele.get(i).click();
							Wait.elementToBeClickable(driver, ele.get(i), 5);
							System.out.println("CLICKING ON THE ELEMENT");
							//testutil.actionMethodClick(driver, ele.get(i));
							ele.get(i).click();
							flag = true;
							i = ele.size();
						}

					}

				}*/

	}
	/*public String getItemId(String status) {
			WebElement itemOfParticularstatus = driver.findElement(By.xpath("(//div[text()='" + status
					+ "']/parent::div//ancestor::div[contains(@data-control-name,'lblUnsoldAddedByCustomerMIS')]/preceding-sibling::div[@data-control-name='lblItemIdAddedByCustomerMIS_1'])[1]"));
			String itemId = itemOfParticularstatus.getText();
			return itemId;
		}
		public Map<String, String> listOfStatus(DataTable testdata) {
			List<String> datadetails = testdata.asList(String.class);
			for (int i = 0; i < datadetails.size(); i++) {
				String strngId = getItemId(datadetails.get(i));
				System.out.println(strngId);
				Seasonstatus.put(datadetails.get(i), strngId);
				System.out.println(Seasonstatus);
			}
			return Seasonstatus;
		}
	 */

	public void SeasonSelection(DataTable testdata) throws InterruptedException {
		List<List<String>> data= testdata.asList(String.class);
		System.out.println(data);
		java.util.Iterator<List<String>> iter=data.iterator();
		driver.findElement(By.xpath("//span[text()='Select Season*']")).click();
		while(iter.hasNext())
		{
			//System.out.println(iter.next());
			WebElement season_ele=driver.findElement(By.xpath("//span[text()='"+iter.next()+"']"));
			season_ele.click();
		}



		//WebElement season_ele=driver.findElement(By.xpath("//span[text()='"+i+"']"));

		/*driver.findElement(By.xpath("//span[text()='Select Season*']")).click();
			WebElement season_ele=driver.findElement(By.xpath("//span[text()='"+testdata+"']"));
			Wait.elementToBeClickable(driver, season_ele, 5);
			season_ele.click();*/
	}
	public void DivisionSelection(DataTable testdata) throws InterruptedException {
		List<List<String>> data= testdata.asList(String.class);
		System.out.println(data);
		java.util.Iterator<List<String>> iter=data.iterator();

		while(iter.hasNext())
		{
			//System.out.println(iter.next());
			Thread.sleep(10000);
			WebElement division_ele=driver.findElement(By.xpath("//div[text()='Division']/ancestor::div[@data-control-name='lblBrowseProductsMenu']/following-sibling::div[@data-control-name='galBrowseProductsMenuOptions']//*[text()='"+iter.next()+"']"));
			// Actions ac=new Actions(driver);
			//ac.moveToElement(division_ele).click().build().perform();
			// testutil.jsclick(driver, division_ele);
			testutil.actionMethodClick(driver, division_ele);
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("argument[0].click()",division_ele);
			// js.executeScript("argument[1].click()",division_ele);
			/* if(division_ele.isDisplayed())
				 {
					 System.out.println("Checkbox is displayed. Clicking on it now");
					 division_ele.click();
			}*/
		}

	}
	public void SectionSelection(DataTable testdata) throws InterruptedException {
		List<List<String>> data= testdata.asList(String.class);
		System.out.println(data);
		java.util.Iterator<List<String>> iter=data.iterator();

		while(iter.hasNext())
		{
			//System.out.println(iter.next());
			Thread.sleep(10000);
			WebElement section_ele=driver.findElement(By.xpath("//div[text()='Section']/ancestor::div[@data-control-name='lblBrowseProductsMenu']/following-sibling::div[@data-control-name='galBrowseProductsMenuOptions']//div[@title='"+iter.next()+"']"));
			// Actions ac=new Actions(driver);
			//ac.moveToElement(division_ele).click().build().perform();
			// testutil.jsclick(driver, division_ele);
			testutil.actionMethodClick(driver, section_ele);
		}

		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("argument[0].click()",division_ele);
		// js.executeScript("argument[1].click()",division_ele);
		/* if(division_ele.isDisplayed())
				 {
					 System.out.println("Checkbox is displayed. Clicking on it now");
					 division_ele.click();
			}*/
	}

	public void DepartmentSelection(DataTable testdata) throws InterruptedException {
		List<List<String>> data= testdata.asList(String.class);
		System.out.println(data);
		java.util.Iterator<List<String>> iter=data.iterator();

		while(iter.hasNext())
		{
			//System.out.println(iter.next());
			Thread.sleep(10000);
			WebElement department_ele=driver.findElement(By.xpath("//div[text()='Department']/ancestor::div[@data-control-name='lblBrowseProductsMenu']/following-sibling::div[@data-control-name='galBrowseProductsMenuOptions']//div[@title='"+iter.next()+"']"));
			// Actions ac=new Actions(driver);
			//ac.moveToElement(division_ele).click().build().perform();
			// testutil.jsclick(driver, division_ele);
			testutil.actionMethodClick(driver, department_ele);
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("argument[0].click()",division_ele);
			// js.executeScript("argument[1].click()",division_ele);
			/* if(division_ele.isDisplayed())
					 {
						 System.out.println("Checkbox is displayed. Clicking on it now");
						 division_ele.click();
				}*/
		}
	}
	public void searchclick()
	{
		searchbtn.click();
	}
	public void SeasonDropDown()
	{
		WebElement Seasonclick = driver.findElement(By.xpath("//div[@class='combobox-view-chevron arrowContainer_1kmq8gc-o_O-container_r2h174-o_O-containerColors_v3pmms']"));
		//Seasonclick.click();
		if (Seasonclick.isDisplayed()) {
			Seasonclick.click();
			System.out.println(driver.getTitle());
		} else {
			System.out.println("Season Dropdown is not available");
		}
	}
	public void CancelSeason(DataTable testdata) throws InterruptedException
	{
	// cancle the selected season
		List<WebElement> cancel=driver.findElements(By.xpath("//*[@class='removeIcon_mv93a6-o_O-removeIcon_1t60t8']"));
		for(int i=0;i<cancel.size();i++)
		{
			cancel.get(i).click();
		}
		
			
	}
	public void MultipleSeason(DataTable testdata) throws InterruptedException
	{
		List<String> data= testdata.asList(String.class);
		System.out.println(data);
		ArrayList<String> arrystring = new ArrayList<String>();
		 for (String seasons : data) {
			    System.out.println(seasons); 
			WebElement mul_season=driver.findElement(By.xpath("//span[text()='"+seasons+"']"));
			mul_season.click();
			List<WebElement> arr=driver.findElements(By.xpath("//div[@data-control-name='btnBorderSelectedFilterPS_1']//div[@class='appmagic-button middle center disabled']"));
			for(int i=0;i<arr.size();i++)
			{
				String str1 = arr.get(i).getText();
				arrystring.add(str1);
			}
			System.out.println(arrystring);
			boolean ans = arrystring.contains(seasons);  
			
			System.out.println(ans);
			
	        if (ans) 
	        {
	        	
	            System.out.println("The list contains " +seasons ); 
	            arrystring.removeAll(arrystring);
		 }
		 }
		 }	
		
		/*
		List<List<String>> data= testdata.asList(String.class);
		System.out.println(data);
		java.util.Iterator<List<String>> iter=data.iterator();
		//driver.findElement(By.xpath("//span[text()='Select Season*']")).click();
		System.out.println(iter);
		Boolean found = false;
		String arrlist = null;
		 List<String> list_expec = new ArrayList<>();
		
		 list_expec.add("202205");
		 list_expec.add("201910");
		 list_expec.add("202001");
		 list_expec.add("201807");
		while(iter.hasNext())
		{
			//System.out.println(iter.next());
			WebElement mul_season=driver.findElement(By.xpath("//span[text()='"+iter.next()+"']"));
			mul_season.click();
			System.out.println(mul_season);
	
			List<WebElement> arr=driver.findElements(By.xpath("//div[@data-control-name='btnBorderSelectedFilterPS_1']//div[@class='appmagic-button middle center disabled']"));
			for(int i=0; i<arr.size(); i++) {
				//System.out.println("inside for loop arrlist");
					 arrlist=  arr.get(i).getText();
				 System.out.println(arrlist);
				 
					 for(int x=0; x<list_expec.size(); x++) {			          
						 
			    if(arr.get(i).getText().contains(list_expec.get(x)) )
					 
	 		          {
			        	  System.out.println(list_expec.get(x)+"  Present in the list");
				          }
			    
				        
					 }
			}
		}
		*/
			
	public void ClickOnPromotion() {
		WebElement clickpromo = driver.findElement(By.xpath("//div[@title='Promotions']"));
		if (clickpromo.isDisplayed()) {
			clickpromo.click();
			System.out.println(driver.getTitle());
		} else {
			System.out.println("Promotion button is not available");
		}
	}
	public void ClickOnGivenPromotion() {
		WebElement clickGivenpromo = driver.findElement(By.xpath("(//div[@data-control-name='lblTempHeightCalProducts'])[1]"));
		if (clickGivenpromo.isDisplayed()) {
			clickGivenpromo.click();
			System.out.println(driver.getTitle());
		} else {
			System.out.println("Promo to not available");
		}
		
		
	}
	public void applyclick()
	{
		applybtn.click();
	}
	public void iconclick()
	{
		Wait.elementToBeClickable(driver, icon, 5);
		icon.click();
		WebElement poptitle=driver.findElement(By.xpath("//div[@data-control-name='CanvasProductDetailsPS']"));
		System.out.println("Pop up title   "+ poptitle.getText().contains("Product description"));
	}
}














