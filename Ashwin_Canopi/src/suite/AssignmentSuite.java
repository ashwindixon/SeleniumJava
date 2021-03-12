package suite;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.SetUp;
import test.ActivityHashmapTest;
import test.EvenLoanListTest;
import test.LoginTest;
import test.SumofLoanTest;
import test.TotalActivitiesTest;

public class AssignmentSuite {
	
	@BeforeSuite
	public void buildUp() throws Exception {
		
		SetUp.mySetup();
		
	}
	
	@Test(priority = 1)
	public void test1() throws IOException {
		LoginTest.testLogin();
		
	}
	
	@Test(priority = 2)
	public void test2() throws IOException {
		TotalActivitiesTest.totalActivities();
		
	}
	
	@Test(priority = 3)
	public void test3() throws IOException {
		SumofLoanTest.sumOfLoan();
		
	}
	
	@Test(priority = 4)
	public void test4() throws IOException {
		ActivityHashmapTest.activityHashmapTest();
		
	}
	
	@Test(priority = 5)
	public void test5() throws IOException {
		EvenLoanListTest.evenLoanListTest();
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		SetUp.tearDown();
	}

}
