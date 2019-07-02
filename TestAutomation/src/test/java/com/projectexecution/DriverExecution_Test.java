package com.projectexecution;

import org.testng.annotations.Test;
import com.genericlibraries.Driver;
import com.genericlibraries.WebDriverCommonUtilities;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DriverExecution_Test extends Driver{
  @Test
  public void f1() {
	  
  }
  @BeforeSuite
  public void lunchBrowser() throws Exception {
	  
	  String BrowserName = WebDriverCommonUtilities.getTestData("Data", 5, 0);
	  String Url = WebDriverCommonUtilities.getTestData("Data", 5, 1);
	  String PageTitle = WebDriverCommonUtilities.getTestData("Data", 5, 2);
	  
	  LunchBrowser(BrowserName, Url, PageTitle);
  }

  @AfterSuite
  public void CloseBrowser() {
	  WebDriverCommonUtilities.quitBrowser();
	  
  }

}
