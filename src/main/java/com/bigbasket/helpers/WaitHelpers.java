package com.bigbasket.helpers;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bigbasket.testbase.TestBase;

import io.appium.java_client.AppiumDriver;

public class WaitHelpers extends TestBase{
	
	public void waitForElementPresent(WebElement element){
		
		new WebDriverWait(driver, 20)
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.ignoring(TimeoutException.class)
		.ignoring(ElementNotVisibleException.class)
		.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementTextPresent(WebElement element,String text){
		
		new WebDriverWait(driver, 20)
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.ignoring(TimeoutException.class)
		.ignoring(ElementNotVisibleException.class)
		.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	

}
