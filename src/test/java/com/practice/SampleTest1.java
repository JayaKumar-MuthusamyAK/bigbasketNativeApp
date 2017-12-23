package com.practice;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bigbasket.helpers.WaitHelpers;
import com.bigbasket.pages.HomePage;
import com.bigbasket.testbase.TestBase;

public class SampleTest1 extends TestBase{

	HomePage practice1;
	WaitHelpers waithelpers;
	String platformName = "ANDROID";
	@BeforeClass
	public void initialize() throws MalformedURLException{
		
		commonSetup(platformName);
		
	}
	
	@Test
	public void searchListingpageValidation(){
		
		practice1= new HomePage(driver);
		practice1.clickon_skipbtn();
		practice1.clickOn_allow();
		waithelpers = new WaitHelpers();
		waithelpers.waitForElementPresent(practice1.currentLocationElement());
		practice1.currentLocation();
		
	}

}
