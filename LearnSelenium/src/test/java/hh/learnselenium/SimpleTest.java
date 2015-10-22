package hh.learnselenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SimpleTest {

	WebDriver driver;
	
	@Before
	public void setup(){
		//Path of the ChromeDriver(not the browser itself) must be set if using chrome.
		if(System.getProperty("os.name").contains("Windows"))
			System.setProperty("webdriver.chrome.driver", "WebDrivers/windows_32/chromedriver.exe");
		if(System.getProperty("os.name").contains("Linux"))
			System.setProperty("webdriver.chrome.driver", "WebDrivers/linux_64/chromedriver");
		
		//Create a ChromeDriver object
		driver = new ChromeDriver();
		
		//Open the page to be tested
		driver.get("http://www.google.com");
		
		//Maximize the window (Optional)
		driver.manage().window().maximize();
		
		//Set implicit waiting time(optional)
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void test(){
		//Find the search field and set the text to be searched
		driver.findElement(By.id("lst-ib")).sendKeys("selenium");
		
		//Click the search button, but the button is invisible unless the mouse stay upon it
		//Use Actions to simulate the motion and get the "click" effect.
		Actions moveToSearchButton = new Actions(driver);
		moveToSearchButton.moveToElement(driver.findElement(By.name("btnK"))).build();
		moveToSearchButton.perform();
		
		//Print the title of the page
		System.out.println(driver.getTitle());
	}
	
	@After
	public void cleanup(){
		//Wait 5 seconds for tester observing
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//close all the windows and quit
		driver.quit();
	}
}
