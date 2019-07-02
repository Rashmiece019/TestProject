package com.bussinesslibraries;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.genericlibraries.WebDriverCommonUtilities;
import com.pageobjectmodel.PrimusBank_HomepageLocators;

public class VerifyPrimusBankFunctionality_TS01 {
	
	static PrimusBank_HomepageLocators Bank = new PrimusBank_HomepageLocators();
	
	public static void verifyLogin_WithoutValue_TC01() throws Exception{
		
		//verify the login Text
		String expLoginText = WebDriverCommonUtilities.getTestData("Data", 8, 0);
		String actLoginText = WebDriverCommonUtilities.getText(Bank.logInText).trim();
		Assert.assertEquals(actLoginText, expLoginText,"Both Login text are not Matched!");
		
		//Select Branch
		
		Select sel = WebDriverCommonUtilities.performSelect(Bank.branchSelection);
		List<WebElement> lst = sel.getOptions();
		String expBranchSelection = WebDriverCommonUtilities.getTestData("Data", 8, 1);
		Boolean flag = false;
		for (WebElement val : lst) {
			String actBranchSelection = val.getText().trim();
			if(actBranchSelection.equals(expBranchSelection)){
				
				sel.selectByVisibleText(actBranchSelection);
				flag=true;
			}
		}
		if(flag==false){
			System.out.println("Expected Branch Name is not available in Branch Selection Drop Down!");
		}
		
		//Verify the Branch Selection text with Actual 
		String currentBranchSelectionText = sel.getFirstSelectedOption().getText().trim();
		Assert.assertEquals(currentBranchSelectionText, expBranchSelection,"Both Branch selection text are not matched!");
		
		//Click Login
		WebDriverCommonUtilities.performClick(Bank.loginButton);

		String alertMessage = WebDriverCommonUtilities.switchToAlert().getText().trim();
		
		System.out.println(alertMessage);
	}
}
