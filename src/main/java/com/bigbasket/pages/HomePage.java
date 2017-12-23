package com.bigbasket.pages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

public class HomePage {
	
    AppiumDriver<WebElement> driver;

	
	@AndroidFindBy(id="com.bigbasket.mobileapp:id/btnSkip")
	private WebElement home_skip_link;
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	private WebElement deny_link;
	
	@AndroidFindBy(id="com.bigbasket.mobileapp:id/btnToCurrentLocation")
	private WebElement useCurrentLocation_Btn;
	
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	private WebElement allow_link;
	
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement location_enable;   //android:id/button2
	
	
	
	public HomePage(AppiumDriver<WebElement> driver2) {
		this.driver = driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver2,20,TimeUnit.SECONDS), this);
	}
	
	
	public void clickon_skipbtn(){
		home_skip_link.click();
		
		/*search_box.sendKeys("Apple");*/
		
	}
	
	public void clickOn_deny(){
		deny_link.click();
	}
	
	public void clickOn_allow(){
		allow_link.click();
	}
	
	public WebElement currentLocationElement(){
		return useCurrentLocation_Btn;
		
	}
	public SearchListingPage currentLocation(){
		useCurrentLocation_Btn.click();
		
		return new SearchListingPage(driver);
	}
	
	
	
	
}
