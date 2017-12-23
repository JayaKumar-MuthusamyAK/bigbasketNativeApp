package com.bigbasket.pages;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.Practice2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchListingPage {

	AppiumDriver<WebElement> driver;
	
	@AndroidFindBy(id="com.bigbasket.mobileapp:id/homePageSearchBox")
	private WebElement search_box;
	
	@AndroidFindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	private WebElement search_count;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='apple']")
	private WebElement search_Suggestion;
	
	
/*	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/txtProductCount']")
	private WebElement search_count;*/
	
	@AndroidFindBy(id="com.bigbasket.mobileapp:id/txtProductDesc")
	private List<WebElement> search_list_Projectname;
	
	@AndroidFindBy(id="com.bigbasket.mobileapp:id/thatsAllFolksTextView")
	private List<WebElement> search_list_end;
	
	//com.bigbasket.mobileapp:id/txtProductDesc
	
	public SearchListingPage(AppiumDriver<WebElement> driver2) {
		this.driver = (AndroidDriver<WebElement>) driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver2,20,TimeUnit.SECONDS), this);
	}
	
	public void getTotalCount() throws InterruptedException{
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("com.bigbasket.mobileapp:id/productListHeaderContainer")).getText());
		System.out.println(search_count.getText());
	}
	
	public void searchProject(String productname) throws InterruptedException{
		search_box.click();
		Thread.sleep(1000);
		driver.getKeyboard().sendKeys(productname);
		Thread.sleep(2000);
		search_Suggestion.click();
		Thread.sleep(3000);
		scrollToElement(driver);
		
	}
	
	public void verify_searchCount(){
		
		/*System.out.println(search_count.getText());*/
		System.out.println(search_list_Projectname.size());
	
	}
	
	public void scrollToElement(AppiumDriver<WebElement> driver){
		
		while(search_list_end.size()==0){
			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			int scrollst = scrollStart-400;
			System.out.println(scrollStart+"-"+scrollst);
			
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			int scrollen = scrollEnd-300;
			System.out.println(scrollEnd+"-"+scrollen);
			driver.swipe(0,scrollStart,0,5,2000);
			System.out.println(search_list_Projectname.size());
		}
		if(search_list_end.size()>=0){
			scrollToElement(driver);
		}
		

	}
	}
