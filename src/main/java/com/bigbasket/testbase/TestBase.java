package com.bigbasket.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	
	
	public static AppiumDriver<WebElement> driver;
	DesiredCapabilities cap;
	
	public static Properties prop;
	public static FileInputStream fileinputstream;
	
	public void commonSetup(String platformName) throws MalformedURLException{
		
		System.out.println(Platform.ANDROID+"-"+platformName);
		if(Platform.ANDROID.toString().equals(platformName)){
			System.out.println("12345678");
		File file = new File(System.getProperty("user.dir")+"\\Drivers\\bigbasket online grocery_v4.1.1_apkpure.com.apk");
		cap = new DesiredCapabilities();
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
		else if(Platform.MAC.toString().equals(platformName)){
			 File classpathRoot = new File(System.getProperty("user.dir"));
		        File appDir = new File(classpathRoot, "/build/");
		        File app = new File(appDir, "WordPress.app");
		        cap.setCapability("platformVersion", "9.2");
		        cap.setCapability("deviceName", "iPhone 6");
		        cap.setCapability("app", app.getAbsolutePath());
		        driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		}
		else {
			System.out.println("Platform Name is Incorrect");
		}
		
		
	}
	
	public void loadproperties() throws IOException {
		prop = new Properties();
		try {
			
			fileinputstream = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\bigbasket\\locators\\homepage.properties");
			prop.load(fileinputstream);
			
			fileinputstream = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\bigbasket\\locators\\InitialSetupPage.properties");
			prop.load(fileinputstream);
			 
			
			fileinputstream = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\bigbasket\\locators\\searchlistingpage.properties");
			prop.load(fileinputstream);
	
			fileinputstream = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\bigbasket\\locators\\product.properties");
			prop.load(fileinputstream);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static WebElement getLocator(String locator) throws Exception {
		
        String[] split = locator.split("->");
		String locatorType = split[0];
		String locatorValue = split[1];
		
		if (locatorType.toLowerCase().equals("id"))
			return driver.findElementById(locatorValue);
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElementByName(locatorValue);
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElementByClassName(locatorValue);
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElementByTagName(locatorValue);
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElementByLinkText(locatorValue);
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElementByPartialLinkText(locatorValue);
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElementByCssSelector(locatorValue);
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElementByXPath(locatorValue);
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
	
	public static List<WebElement> getLocators(String locator) throws Exception {
        String[] split = locator.split("->");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElementsById(locatorValue);
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElementsByName(locatorValue);
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElementsByClassName(locatorValue);
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElementsByTagName(locatorValue);
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElementsByLinkText(locatorValue);
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElementsByPartialLinkText(locatorValue);
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElementsByCssSelector(locatorValue);
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElementsByXPath(locatorValue);
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
	
	public static WebElement getWebElement(String locator) throws Exception{
		return getLocator(prop.getProperty(locator));
		
	}
	
	public static List<WebElement> getWebElements(String locators) throws Exception{
		return getLocators(prop.getProperty(locators));
		
	}
	
	

}
