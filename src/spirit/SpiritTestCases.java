package spirit;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class SpiritTestCases {
	@Ignore
	@Test
	public void testSearch() {
		//Gets error when selecting To city.
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumSetUp\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spirit.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("flight-OriginStationCode")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);  //implicit wait
		driver.findElement(By.xpath("//button[contains(text(),'Columbus, OH (CMH)')]")).click();
		driver.findElement(By.id("flight-DestinationStationCode")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);  //implicit wait
		driver.findElement(By.xpath("/descendant::button[contains(text(),'San Diego, CA (SAN)')][2]")).click();
		//Click Search Flights
		driver.findElement(By.xpath("//button[contains(text(),' Search Flights ')]")).click();
		String holdval = driver.findElement(By.className("headline1")).getText();
		Assert.assertEquals("Choose Your Flight", holdval);
		
		
		 
	
		// class a / class b.  How do I read a variable from class A inside of B?
		
		
		driver.close();
				
		//driver.findElement(By.id(id)).click;
		//btn btn-primary d-block
		System.out.println("debug stop");
		 
		 		 
	}
	
	//@Ignore
	@Test
	public void testSearchVacation() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumSetUp\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spirit.com");
		driver.manage().window().maximize();	
		driver.findElement(By.id("vacation")).click();
		String travelText = driver.findElement(By.xpath("//span[contains(text(),'Flight + Hotel + Car')]")).getText();
		Assert.assertEquals(travelText, "Flight + Hotel + Car" );
		// How to tell if Flight + Hotel + Car exists and if it is selected?
		/*  //*[@id="vacation-panel"]/app-package-search/div/form/div[1]/div[3]/div/div/app-input[3]/div/label/span */
		driver.close();
		System.out.println("debug  testSearchVacation stop");
		
	}
	
	@Ignore
	@Test
	public void testSearchCar() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumSetUp\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spirit.com");
		driver.manage().window().maximize();	
		driver.findElement(By.id("car")).click();
		//How do I switch to new open window?  	
		//How switch between entire browsers?
		
		Object[] thiswin = driver.getWindowHandles().toArray();
		driver.switchTo().window(thiswin[1].toString());
		
		// String URL = driver.getCurrentUrl();   this way is good also.
		
		String carTabName = driver.getTitle();
		
		Assert.assertEquals(carTabName, "Compare Cheap Car Rentals" );
		
		//Close the cars tab, the Spirit tab and then the entire Browser
		
		driver.close();
		driver.switchTo().window(thiswin[0].toString());
		System.out.println("Tab Focus:  " + driver.getTitle());
		driver.quit();
		
		System.out.println("debug  testSearchCar stop");
		
	}

}

// To save updates to www.github.com:
// Right click on Project.  Teams. Commit.
