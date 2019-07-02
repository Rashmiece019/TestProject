package com.genericlibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonUtilities extends Driver {
	
	//Highlight the element

	public static void elementHighlighter(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) (getDriver());
		js.executeScript("arguments[0].style.border='3px solid BLUE';", getDriver().findElement(locator));
	}

	// Enter Text

	public static void enterValue(By locator, String val) {
		elementHighlighter(locator);
		getDriver().findElement(locator).sendKeys(val);
	}

	// Clear Enter
	public static void clearEnterValue(By locator, String val) {
		elementHighlighter(locator);
		getDriver().findElement(locator).clear();
		getDriver().findElement(locator).sendKeys(val);
	}

	// click
	public static void performClick(By locator) {
		elementHighlighter(locator);
		getDriver().findElement(locator).click();
	}

	// ScreenShots
	public static void captureScreenShots() {

		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String FinalDate = sdf.format(date);

			EventFiringWebDriver efd = new EventFiringWebDriver(getDriver());
			File srcImage = efd.getScreenshotAs(OutputType.FILE);
			File dstLoc = new File("src/test/resources/ScreenShots" + FinalDate + ".png");
			FileUtils.copyFile(srcImage, dstLoc);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Get the Web Text
	public static String getText(By locator) {
		elementHighlighter(locator);
		String val = getDriver().findElement(locator).getText().trim();
		return val;
	}

	// Get Text Box Value
	public static String getTextBoxValue(By locator, String attribueName) {
		elementHighlighter(locator);
		String val = getDriver().findElement(locator).getAttribute(attribueName).trim();
		return val;

	}

	// Select a value from box
	public static Select performSelect(By locator) {
		elementHighlighter(locator);
		Select sel = new Select(getDriver().findElement(locator));
		return sel;
	}

	// Action
	public static Actions performAction(By locator) {
		elementHighlighter(locator);
		Actions act = new Actions(getDriver());
		return act;
	}
	
	//Switch to Alert
	public static Alert switchToAlert(){
		Alert alt = getDriver().switchTo().alert();
		return alt;
	}
	
	//Normal Wait
	public static void normalWait(int time){
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Wait for Page load
	public static void waitForPageLoad(int time){
		getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	//Wait till element found
	public static void waitForElement(int time, By locator){
	elementHighlighter(locator);
	WebDriverWait wait = new WebDriverWait(getDriver(), time);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//Switch to latest window
	public static void switchToLatestWindow(String expTitle){
		Set<String> set  = getDriver().getWindowHandles();
		for (String win : set) {
			System.out.println("Window ID's : "+win);
			getDriver().switchTo().window(win);
			String actualTitle = getDriver().getTitle().trim();
			if (expTitle.equals(actualTitle)) {
				System.out.println("You have switched to "+actualTitle+" window.");
				break;
			}
		}
	}
	
	//Close the current window
	public static void closeLatestWindow(String expTitle){
		Set<String> set  = getDriver().getWindowHandles();
		for (String win : set) {
			getDriver().switchTo().window(win);
			String actualTitle = getDriver().getTitle().trim();
			if (expTitle.equals(actualTitle)) {
				System.out.println("You have successfully closed "+actualTitle+" window.");
				getDriver().close();
				break;
			}
		}
	}
	
	//Get the data from the excel sheet

	public static String getTestData(String sheetName,int rowNo,int cellNo) throws Exception{
		FileInputStream  fis = new FileInputStream("src/test/resources/ProjectTestData/TestData.xlsx");
		Workbook  wb = WorkbookFactory.create(fis);
		Sheet  sh  = wb.getSheet(sheetName);
		Row  rw = sh.getRow(rowNo);
		String val  = rw.getCell(cellNo).getStringCellValue();
		return val;
	}
	
	//write Data into Excel
	public static void setTestData(String sheetName,int rowNo ,
			int cellNo,String passVal) throws Exception{

		String filePath = "src/test/resources/ProjectTestData/TestData.xlsx";
		FileInputStream  fis = new FileInputStream(filePath);
		Workbook  wb = WorkbookFactory.create(fis);
		Sheet  sh = wb.getSheet(sheetName);
		Row  rw = sh.getRow(rowNo);
		Cell  cel = rw.createCell(cellNo);
		cel.setCellValue(passVal);
		FileOutputStream  fos = new FileOutputStream(filePath);
		wb.write(fos);
	}
	
	//Quit Browser
	
	public static void quitBrowser(){
		getDriver().quit();
	}
	
	public static void CloseBrowser(){
		getDriver().close();
	}
	
}