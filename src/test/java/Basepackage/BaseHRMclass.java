package Basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.Timeutility;

public class BaseHRMclass {
   public static Properties prop= new Properties();
   public static WebDriver driver;
    
    public BaseHRMclass() {
    	
    	try {
    	FileInputStream file=new FileInputStream("C:\\Users\\Prata\\OneDrive\\Desktop\\Eclipse\\HRmanagement\\src\\test\\java\\environmentvariables\\config.properties");
    	prop.load(file);
    }
    	catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	catch(IOException a) {
    		a.printStackTrace();}
    	}
    	public static void Initiation() {
    		String browsername=prop.getProperty("browser");
    		if(browsername.equals("Firefox")) {
    			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
    			driver=new FirefoxDriver();
    		}
    		else if (browsername.equals("chrome")){
    			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    			driver=new ChromeDriver();
    		
    		}
    		driver.manage().window().maximize();
    		driver.manage().timeouts().pageLoadTimeout(Timeutility.timepage,TimeUnit.SECONDS);
    		driver.get(prop.getProperty("url"));
    	}
    	
    
}
