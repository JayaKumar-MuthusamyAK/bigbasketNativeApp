package com.bigbasket.helpers;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class ScrollFuctionHelper {
	
	AppiumDriver<WebElement> driver;
	
	public void scrollDownUptoParticularElement(AppiumDriver<WebElement> driver,List<WebElement> element){
		
		while(element.size()==0){
			Dimension dimensions = driver.manage().window().getSize();
			int scrollStart = (int) (dimensions.getHeight() * 0.5);
			int scrollEnd = (int) (dimensions.getHeight() * 0.2);
			driver.swipe(0,scrollStart,0,scrollEnd,2000);
		}
		
		
		if(element.size()>=0){
			scrollDownUptoParticularElement(driver,element);
		}

	}
	
	public void scrolldown(AppiumDriver<WebElement> driver){
		
		    Dimension dimensions = driver.manage().window().getSize();
		    int Startpoint = (int) (dimensions.getHeight() * 0.5);
		    int scrollEnd = (int) (dimensions.getHeight() * 0.2);
		    driver.swipe(0, Startpoint,0,scrollEnd,2000); 
	}
	
	public void scrollUp(AppiumDriver<WebElement> driver){
		Dimension dimensions = driver.manage().window().getSize();
		int scrollStart = (int) (dimensions.getHeight() * 0.5);
		int scrollEnd = (int) (dimensions.getHeight() * 0.2);
		driver.swipe(0,scrollEnd,0,scrollStart,2000);

	}

}
