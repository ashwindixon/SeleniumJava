package test;

import org.testng.Reporter;

import main.HomePage;

public class TotalActivitiesTest {
	
	public static void totalActivities() {
		
		Reporter.log("Entering Total Activities testcase");
		HomePage.seeActivities();
		String totalEntry = HomePage.totalEntries();
		System.out.println("Total Entries in the activity :- "+totalEntry);	
		
		Reporter.log("Total Activity Entries is "+totalEntry);
		
	}

}
