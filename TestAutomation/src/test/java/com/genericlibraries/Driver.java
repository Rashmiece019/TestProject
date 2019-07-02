package com.genericlibraries;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class Driver {
	private static WebDriver dr = null;

	/**
	 * @author Rashmi
	 * @param dr
	 * @return WebDriver
	 */
	public static WebDriver getDriver() {
		return dr;
	}

	public static void LunchBrowser(String BrowserName,String url,String pageTitle) {
		if (BrowserName.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserFiles/chromedriver.exe");
			dr = new ChromeDriver();
			System.out.println("Default Chrome Browser is Lunched");
		} else if (BrowserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.firefox.marionette", "src/test/resources/BrowserFiles/geckodriver.exe");
			dr = new FirefoxDriver();
			System.out.println("FireFox Browser is Lunched");
		} else if (BrowserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "src/test/resources/BrowserFiles/IEDriverServer.exe");
			dr = new InternetExplorerDriver();
			System.out.println("Internet Explorer Browser is Lunched");
		} else {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserFiles/chromedriver.exe");
			System.out.print("Default Chrome Browser is Lunched");
			System.out.println("sucessfully");
		}
		getDriver().manage().window().maximize();
		getDriver().get(url);
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		Assert.assertEquals(pageTitle, getDriver().getTitle().trim(),"Both Title are not Same!");

	}
}
