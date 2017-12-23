package com.bigbasket.keywords;

import java.net.MalformedURLException;

import com.bigbasket.helpers.WaitHelpers;
import com.bigbasket.testbase.TestBase;

public class CommonAppKeywords extends TestBase{

	WaitHelpers waithelpers = new WaitHelpers();
	public String choosePhone(String datakeys) throws MalformedURLException {
		
		try{
			commonSetup(datakeys);
		}catch(Exception e){
			return e.getMessage();
		}
		
		return "Pass";
	}

	public String click(String objectkeys) {
		try{
			getWebElement(objectkeys).click();
		}
		catch(Exception e){
			return e.getMessage();
		}
		return "Pass";
	}

	public String waitForElementPresent(String objectkeys) {
		
		try{
			waithelpers.waitForElementPresent(getWebElement(prop.getProperty(objectkeys)));
		}
		catch(Exception e){
			return e.getMessage();
		}
		
		return "Pass";
	}

	public String type(String objectkeys, String datakeys) {
		
		try{
			driver.getKeyboard().sendKeys(datakeys);
		}catch(Exception e){
			return e.getMessage();		
		}
		return "Pass";
	}
	
	
	

}
