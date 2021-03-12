package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends ObjectRepository{
	
	public static void logIn(String user, String pass) {
		
		
		WebDriverWait wait = new WebDriverWait(driver,3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginText)));
		driver.findElement(By.xpath(loginText)).sendKeys(user);
		driver.findElement(By.xpath(passwordText)).sendKeys(pass);
		driver.findElement(By.xpath(submitBtn)).click();
		
		
	}
	
	public static void seeActivities() {
		
		WebDriverWait wait = new WebDriverWait(driver,3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(activityBtn)));
		driver.findElement(By.xpath(activityBtn)).click();
		
	}
	
	public static String totalEntries() {
		
		WebDriverWait wait = new WebDriverWait(driver,3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(activityInfo)));
		String info = driver.findElement(By.xpath(activityInfo)).getText();
		String totalEntry = info.split(" ")[5];
		return totalEntry;
		
	}
	
	public static int sumPfLoanNo() {
		
		String nextClass = driver.findElement(By.xpath(tableNext)).getAttribute("class");
		int sum = 0;
		while(nextClass.equals("paginate_button next")) {
			List<WebElement> loans = driver.findElements(By.xpath(activityTableLoan));
			for(WebElement i:loans) {
				sum= sum+Integer.valueOf(i.getText());
				}
			nextClass = nextTable();
		}
		return sum;
	}
	
	public static HashMap loanActivityMap() {	
		
		driver.findElement(By.xpath(actBtn)).click();
		String nextClass = driver.findElement(By.xpath(tableNext)).getAttribute("class");
		HashMap<String, String> activityMap = new HashMap<String, String>();
		
		while(nextClass.equals("paginate_button next")) {
			List<WebElement> loans = driver.findElements(By.xpath(activityTableLoan));
			List<WebElement> status = driver.findElements(By.xpath(activityTableStatus));
			for(int i=0;i<loans.size();i++) {
			
				activityMap.put(loans.get(i).getText(), status.get(i).getText());
			
			}
			nextClass = nextTable();
		}
		return activityMap;
		
	}
	
	public static String nextTable() {
			
		String nextClass;
		if(driver.findElement(By.xpath(tableNext)).getAttribute("class").equals("paginate_button next disabled")) {
			System.out.println("Next button disabled");
		}
		else {
			driver.findElement(By.xpath(tableNext)).click();
		}
		nextClass= driver.findElement(By.xpath(tableNext)).getAttribute("class");
		return nextClass;
		}

	public static List evenLoanNumber() {
		
		driver.findElement(By.xpath(actBtn)).click();
		List<String> evenLoan = new ArrayList<String>();
		String nextClass = driver.findElement(By.xpath(tableNext)).getAttribute("class");
		while(nextClass.equals("paginate_button next")) {
			List<WebElement> loans = driver.findElements(By.xpath(activityTableLoan));
			for(WebElement i:loans) {
				if(Integer.valueOf(i.getText())%2==0) {
					evenLoan.add(i.getText());
				}
				}
			nextClass = nextTable();
		}
		
		
		return evenLoan;
		
	}
		
	

}
