package main;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SetUp {

	public static WebDriver driver;
	public static void mySetup() throws Exception {
		
		System.out.println("Inside Setup method");
		Properties prop = new Properties();
		FileInputStream finp = new FileInputStream(
				System.getProperty("user.dir")+"/ConfigFolder/global.properties");
		prop.load(finp);
		
		String brows = prop.getProperty("browser");
		System.out.println("Browser: "+ brows);
		
		if(brows.contains("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(brows.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(brows.contains("ie")) {
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		else {
			System.out.println("Browser not identified");
		}
		
		String url = prop.getProperty("url");
		System.out.println("Opening URL: "+ url);
		driver.get(url);
		driver.manage().window().maximize();
				
		
	}
	
	public static void tearDown() {
		driver.quit();
	}
	
	
}
