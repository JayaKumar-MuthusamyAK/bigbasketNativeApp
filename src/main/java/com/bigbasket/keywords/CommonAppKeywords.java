package com.bigbasket.keywords;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.bigbasket.helpers.ScrollFuctionHelper;
import com.bigbasket.helpers.WaitHelpers;
import com.bigbasket.testbase.TestBase;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class CommonAppKeywords extends TestBase{

	WaitHelpers waithelpers = new WaitHelpers();
	ScrollFuctionHelper scrollhelper= new ScrollFuctionHelper();
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

	public String sampleFuction() throws InterruptedException {
		
		Thread.sleep(3000);
		List<WebElement> list = driver.findElementsByXPath("//android.widget.RelativeLayout/android.widget.TextView[@index='2']");
		for(WebElement li :list){
			System.out.println(li.getText());
		}
		
		return "Pass";
	}

	public String addProduct(String objectkeys, String datakeys) throws Exception {
		
		String locator1 = objectkeys.split("\\|")[0];
		String locator2 = objectkeys.split("\\|")[1];
		
		List<WebElement> projectName_list = getWebElements(locator1);
		
		System.out.println(projectName_list.size());
	
		System.out.println(projectName_list.get(0).getText());
		
		boolean foundProject=false;
		while(foundProject==false){
			for(int i=0; i<projectName_list.size();i++){
				/*System.out.println(projectName_list.get(i).getText()+"--"+datakeys);*/
				if(projectName_list.get(i).getText().equals(datakeys)){
					getWebElement(locator2).click();
					foundProject =true;
					break;
				}
				else{
					scrollhelper.scrolldown(driver);
					projectName_list = getWebElements(locator1);
				}
				
				/*ToDo State needs to do*/
		}
	
		}
		
		return "Pass";
	}
	
	
	

}
