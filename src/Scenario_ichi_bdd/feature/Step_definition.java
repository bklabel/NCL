package Scenario_ichi_bdd.feature;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Step_definition {
	WebDriver driver=null;
	@Given("^a Guest$")
	public void Login_as_a_guest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumSetUp\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://www.NCL.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title='Explore']")).click();
		Thread.sleep(3000);
	}
	
	@And("^I am on Homepage$")
	public void assert_home_page() {
		Assert.assertEquals("Cruises & Cruise Deals | Plan Your Cruise Vacation | NCL", driver.getTitle());
	}
	
	@Given("^I navigated to Ports page$")
	public void navigate_to_ports_page() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='Ports']")).click();
		Thread.sleep(6000);
	}
	
	//@When("I navigated to ports page")
	//public void search_port() {
		
	//}
	@When("^I search for Honolulu port$")
	public void search_for_Honolulu_port() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='searchbar']")).click();
		driver.findElement(By.xpath("//*[@id='searchbar']")).sendKeys("Honolulu");
		Thread.sleep(2000);
	}
	@Then("^Map zoomed to show selected port$")
	public void map_zoomed_for_selected_port() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='Honolulu, Oahu']")).click(); // title = Honolulu, OAHU
		Thread.sleep(6000);
	}
	@And("^Port is on the middle of the map$")
	public void port_middle_of_map() {
		Dimension dim = driver.manage().window().getSize();
	    int x;
	    int y;
	    x = dim.getWidth();
	    System.out.println("x screen:  " +  x);
	    y = dim.getHeight();	
	    System.out.println("y screen:  " +  y);
	    Point pt = driver.findElement(By.xpath("//div[contains(text(),'Honolulu')]")).getLocation();
	    double elementx = pt.getX();
	    System.out.println("x element :  " +  elementx);
	    double elementy = pt.getY();
	    System.out.println("y element:  " +  elementy);
	    
	    double half_screenx = x/2;
	    double half_screeny = y/2;
	    
	    double xdifference = half_screenx - elementx;
	    double ydifference = half_screeny - elementy;
	    
	    // make them absolute positive values
	    if (xdifference < 0)
	      xdifference = xdifference * -1;
	      
	    if (ydifference < 0)
	      ydifference = ydifference * -1;
	     
	    // check if in middle
	    if (xdifference < 120) 
	    {
	      System.out.println("Honolulu is in the correct horizontal location");
	    } else 
	    {
	    System.out.println("Honolulu is NOT in the correct horizontal location");
	    }
	    if (ydifference < 120)
	    {	
	    System.out.println("Honolulu is in the correct vertical location");
	    } else
	    {
	    System.out.println("Honolulu is NOT in the correct vertical location");
	    }
	}
	@Then("^Port displayed as Port Of Departure$")
	public void Port_displayed_as_Port_Of_Departure() throws Throwable {
	    Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'departure')]")).isDisplayed());
	}
}



