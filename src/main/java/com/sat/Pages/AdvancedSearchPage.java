package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sat.testUtil.Testutil;

public class AdvancedSearchPage {
	private WebDriver driver;
	Testutil testutil = new Testutil();

	@FindBy(xpath = "//div[@data-control-name='icnAdvanceSearch']")
	private WebElement AdvancedSearchIcon;
	
	@FindBy(xpath = "//div[@data-control-name='lblAdvSrch']")
	private WebElement AdvancedSearchPageTitle;
	
	@FindBy(xpath = "//div[@data-control-name='lblAdvSrchHeader']")
	private WebElement AdvancedSearchPageText;
	
	@FindBy(xpath = "//input[@appmagic-control='TxtKeywordAdvtextbox']")
	private WebElement keyWordFieldText;
	
	@FindBy(xpath = "//input[@appmagic-control='TxtBrandAdvtextbox']")
	private WebElement BrandEntryBox;
	
	@FindBy(xpath = "//div[@data-control-name='cbCategoryAdv']")
	private WebElement catogeryComboBox;
	
	@FindBy(xpath = "//ul[@role='listbox']")
	private WebElement Categorylists;
	
	@FindBy(xpath = "//input[@appmagic-control='TxtMinPriceAdvtextbox']")
	private WebElement minPrice;
	
	@FindBy(xpath = "//input[@appmagic-control='TxtMaxPriceAdvtextbox']")
	private WebElement maxPrice;
	
	@FindBy(xpath = "//div[@id='react-combobox-view-1']")
	private WebElement statusDropDown;
	
	@FindBy(xpath = "//div[text()='CANCEL']")
	private WebElement cnclbtn;
	
	@FindBy(xpath = "//div[text()='SEARCH']")
	private WebElement savebtn;
	
	
	public AdvancedSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnAdvancedSearchIcon() {
		testutil.actionMethodClick(driver, AdvancedSearchIcon);
	}
	public void validateAdvSrchPageTitle(String AdvSrch, String advsrchtxt) {
		String advcsrchtitle = AdvancedSearchPageTitle.getText();
		assertTrue(AdvSrch.equalsIgnoreCase(advcsrchtitle));
		String advcsrchtext = AdvancedSearchPageText.getText();
		assertTrue(advsrchtxt.equalsIgnoreCase(advcsrchtext));
	}
	public void validateKeyWordField(String keywrdtext) {
		String keyWordText = keyWordFieldText.getAttribute("placeholder");
		assertTrue(keywrdtext.equalsIgnoreCase(keyWordText));
	}
	
	public void validateBrandEntryBox() {
		//BrandEntryBox.click();
		String fieldType = BrandEntryBox.getAttribute("type");
		assertTrue(fieldType.equalsIgnoreCase("text"));
	}
	
	public void validateCategoryDropDown() {
		catogeryComboBox.click();
		String CategoryBox = Categorylists.getAttribute("role");
		assertTrue(CategoryBox.equalsIgnoreCase("listbox"));
	}
	public void fillMinAndMaxPrice(String minprc, String maxprc) {
		//minPrice.click();
		minPrice.clear();
		minPrice.sendKeys(minprc);
		//maxPrice.click();
		maxPrice.clear();
		maxPrice.sendKeys(maxprc);
	}
	public void clickOnStatusDropDown(String stsdrpdwn) {
		statusDropDown.click();
		WebElement statusDropDown = driver.findElement(By.xpath("//div[@id='powerapps-flyout-react-combobox-view-1']//span[text()='"+stsdrpdwn+"']"));
		statusDropDown.click();
	}
	public void validateSearchAndCancleBtn() {
		 assertTrue(cnclbtn.isDisplayed());
		 assertTrue(savebtn.isDisplayed());
	}

}
