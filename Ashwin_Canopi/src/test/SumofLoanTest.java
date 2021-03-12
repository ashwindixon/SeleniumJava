package test;

import org.testng.Reporter;

import main.HomePage;

public class SumofLoanTest {
	
	public static void sumOfLoan() {
		
		Reporter.log("Entering Sum of Loan Number testcase");
		int sum = HomePage.sumPfLoanNo();
		System.out.println("The sum of Loan Numbers is :- "+sum);
		Reporter.log("Sum of Loan number is "+String.valueOf(sum));
		
	}

}
