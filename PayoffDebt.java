/*
 * [NetPay].java
 * Author:  [Tom Kunampuram] 
 * Submission Date:  [01/23/2023]
 *
 * Purpose: A brief paragraph description of the
 * program. What does it do?
 * Based on user input on the principal, annual interest rate, and the monthly payment, 
 * the program gives an output on the number of months needed to pay of credit card
 * debt.
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */
/**
 * 
 */

/**
 * @author Kunamp
 *
 */
import java.util.Scanner;
import java.lang.Math; 

public class PayoffDebt {

	public static void main(String[] args) {
		
		Scanner Keyboard = new Scanner(System.in);
		
		/*This prompts the user to enter the principal, annual interest rate,
		and their monthly payment which will then be used to calculate the 
		overpayment, total interest paid, months needed to pay off debt, 
		and the total amount paid.
		*/
		System.out.print("Principal:\t\t\t\t");
		double principal = Keyboard.nextDouble();
		System.out.print("Annual Interest Rate (%):\t\t");
		double annualInterest = Keyboard.nextDouble();
		System.out.print("Monthly Payment:\t\t\t");
		double monthlyPayment = Keyboard.nextDouble();
		
		//This calculates the months needed and outputs the rounded months as an integer
		double monthsNeeded = (Math.log(monthlyPayment)-Math.log(monthlyPayment-annualInterest/1200.0*principal))/Math.log(annualInterest/1200.00+1.0);
		double roundedMonths = Math.ceil(monthsNeeded);
		System.out.println("\nMonths Needed to Pay Off:\t\t" + (int)roundedMonths);
		
		/*This calculates the total amount paid 
		 * and outputs the total amount paid to the nearest two decimal places 
		 * by multiplying the rounded months by monthly payment.
		 */
		double totalAmountPaid = roundedMonths * monthlyPayment;
		double roundedAmount = Math.ceil(totalAmountPaid);
		System.out.printf("Total Amount Paid:\t\t\t$%.2f" , totalAmountPaid);
		
		/*This calculates the total interest paid and 
		 * outputs the total interest paid to the nearest two decimal places
		 * by subtracting the principal from total amount paid.
		 */
		double totalInterest = totalAmountPaid - principal;
		double roundedInterest = Math.ceil(totalInterest);
		System.out.printf("\nTotal Interest Paid:\t\t\t$%.2f" , totalInterest);
		
		/*This calculates the total overpayment and outputs
		 * it to the nearest two decimal places by multiplying months needed
		 * by monthly payment and then subtracting that from the total amount paid.
		 */
		double overpayment = totalAmountPaid - (monthsNeeded * monthlyPayment);
		System.out.printf("\nOverpayment:\t\t\t\t$%.2f" , overpayment);
		
		Keyboard.close();
	}

}
