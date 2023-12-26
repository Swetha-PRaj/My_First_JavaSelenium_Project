package com.sat.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sat.testbase.TestBase;

public class Demo {
	private WebDriver driver;
	public Demo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		TestBase.getDriver().get("//a[@class = 'jfHeader-menuListLink jfHeader-dynamicLink jfHeader-signup-action signup']");
	}
	
	    WebElement select_MSB = driver.findElement(By.xpath("(//*[@id='multiselect1']/option)[1]"));
    WebElement txt_P1L1 = driver.findElement(By.className("post-footer-line post-footer-line-1"));
    WebElement txt_TAF = driver.findElement(By.id("ta1"));
    WebElement txt_TAF2 = driver.findElement(By.xpath("(//div[@class='widget-content']/textarea)[2]"));
    WebElement drpdwn_oldnwsltr = driver.findElement(By.className("combobox"));
    WebElement txt_Sampletext = driver.findElement(By.xpath("//*[@id='Text1']/div[1]"));
    public void resaleAppLogin(String userid, String password) throws InterruptedException {
}
}
