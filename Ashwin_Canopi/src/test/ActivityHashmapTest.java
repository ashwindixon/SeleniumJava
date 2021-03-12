package test;

import java.util.HashMap;

import org.testng.Reporter;

import main.HomePage;

public class ActivityHashmapTest {

	public static void activityHashmapTest() {
		
		Reporter.log("Entering Activity Hashmap testcase");
		HashMap<String,String> activityMap = HomePage.loanActivityMap();
		System.out.println(activityMap.get("74762"));
		System.out.println("The size of Activity Hashmap is :- "+activityMap.size());
		Reporter.log("Size of Hashmap is "+String.valueOf(activityMap.size()));
		
	}
	
}
