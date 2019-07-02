package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {
      
	public static void main(String[] args) {
		WebDriver d=new FirefoxDriver();
		d.get("http://www.facebook.com");
		System.out.println(d.getTitle().trim());
		

	}
	
	}
	
