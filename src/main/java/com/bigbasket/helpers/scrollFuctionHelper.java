package com.bigbasket.helpers;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class scrollFuctionHelper {
	
	AppiumDriver<WebElement> driver;
	
	public void scrollDownUptoParticularElement(AppiumDriver<WebElement> driver,List<WebElement> element){
		
		while(element.size()==0){
			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			driver.swipe(0,scrollStart,0,scrollEnd,2000);
		}
		
		
		if(element.size()>=0){
			scrollDownUptoParticularElement(driver,element);
		}

	}
	
	public void scrollUp(AppiumDriver<WebElement> driver){
		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollEnd,0,scrollStart,2000);

	}

}
