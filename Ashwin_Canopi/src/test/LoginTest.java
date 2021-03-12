package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.HomePage;
import main.SetUp;

public class LoginTest {
	
	@Test
	public static void testLogin() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream finp = new FileInputStream(
				System.getProperty("user.dir")+"/ConfigFolder/global.properties");
		prop.load(finp);
		Reporter.log("Entering Login test case");
		HomePage.logIn(prop.getProperty("username"),prop.getProperty("password"));		
		
	}

}
