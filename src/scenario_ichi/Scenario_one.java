package scenario_ichi;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Point;

public class Scenario_one {

	    
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumSetUp\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.NCL.com");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//a[@title='Explore']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@title='Ports']")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id='searchbar']")).click();
			driver.findElement(By.xpath("//*[@id='searchbar']")).sendKeys("Honolulu");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='Honolulu, Oahu']")).click(); // title = Honolulu, OAHU
			Thread.sleep(6000);
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

}