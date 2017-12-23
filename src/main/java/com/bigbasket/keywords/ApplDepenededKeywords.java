package com.bigbasket.keywords;

import com.bigbasket.helpers.WaitHelpers;
import com.bigbasket.testbase.TestBase;

public class ApplDepenededKeywords extends TestBase{

	
	public String click(String datakeys) {
		
		try{
			new WaitHelpers().waitForElementPresent(driver.findElementByXPath("//android.widget.TextView[@text='"+datakeys+"']"));
			driver.findElementByXPath("//android.widget.TextView[@text='"+datakeys+"']").click();;
		}
		catch(Exception e){
			return e.getMessage();
		}
		
		return "Pass";
	}

	
	
}
