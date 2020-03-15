package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {
	WebDriver driver = null;
	try{
		System.setProperty("webdriver.chrome.driver", "src/lib/Browser/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.flipkart.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		if (expectedTitle.equals(actualTitle)) {

			System.out.println("Both title are same!");
			System.out.println("Title is :" + actualTitle);

		} else {

			System.err.println("Title does not matched!");
		}

		WebElement pupup = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		boolean flag = pupup.isDisplayed();
		if (flag) {

			pupup.click();

		} else {

			System.err.println("login Pupup is not present!");
		}

		// pass iphone in search text box
		driver.findElement(By.className("LM6RPg")).sendKeys("iPhone");
		// click the search button
		driver.findElement(By.className("vh79eN")).click();
		Thread.sleep(3000);

	}catch(Exception e)
	{
		System.out.println(e);
	}
}
