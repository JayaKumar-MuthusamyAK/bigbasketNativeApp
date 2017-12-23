package com.practice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bigbasket.pages.HomePage;
import com.bigbasket.pages.SearchListingPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Practice2 {
	
	public static AndroidDriver<WebElement> driver;
	@BeforeClass
	public void capabilitiesSetup() throws MalformedURLException{
		
			
		File file = new File(System.getProperty("user.dir")+"\\Drivers\\bigbasket online grocery_v4.1.1_apkpure.com.apk");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.BROWSER_NAME, "Android");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY223L6BND");
			cap.setCapability(MobileCapabilityType.APP, file);
			/*cap.setCapability("appPackage", "com.bigbasket.mobileapp");
			cap.setCapability("appActivity", "com.bigbasket.mobileapp.activity.SplashActivity");*/
			
			
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void searchItem() throws InterruptedException{
		
		
		HomePage practice1= new HomePage(driver);
		practice1.clickon_skipbtn();
		practice1.clickOn_allow();
		Thread.sleep(3000);
		practice1.currentLocation();
		SearchListingPage obj1 = new SearchListingPage(driver);
		Thread.sleep(3000);
		obj1.searchProject("Apple");
		obj1.getTotalCount();
		
		
	}

}
