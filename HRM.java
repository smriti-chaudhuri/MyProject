package orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HRM {
	
	WebDriver driver;
	@BeforeSuite
	public void driversetup() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	}
	@BeforeMethod
	public void Initialsetup() {
		driver= new FirefoxDriver();
		 driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
	}
	@Test
	public void typename()  {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b")).click();
		driver.findElement(By.linkText("Contact Details")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("contact_street1")).sendKeys("Overlea drive");
		driver.findElement(By.id("contact_city")).sendKeys("Kitchener"); 

}
}
