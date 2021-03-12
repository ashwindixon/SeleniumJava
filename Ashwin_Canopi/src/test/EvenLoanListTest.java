package test;

import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.Test;

import main.HomePage;

public class EvenLoanListTest {
	
	@Test
	public static void evenLoanListTest() {
		
		Reporter.log("Entering Activity Hashmap testcase");
		List<String> evenLoan =  HomePage.evenLoanNumber();
		System.out.println(evenLoan);
		System.out.println("The size of even loan number is :- "+evenLoan.size());
		Reporter.log("Size of Even Loan number list is "+String.valueOf(evenLoan.size()));
		
	}

}
