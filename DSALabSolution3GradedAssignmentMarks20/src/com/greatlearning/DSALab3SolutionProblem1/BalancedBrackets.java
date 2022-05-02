package com.greatlearning.DSALab3SolutionProblem1;
import java.util.*;
//import java.util.Scanner;
//Java program for checking balanced brackets
//Sample Input Examples
//A balanced Bracketed string is ([[{}]])
//An Unbalanced bracketed string is ([[{}]]))

 public class BalancedBrackets {

 // method to check if brackets are balanced
  static boolean checkingBracketsBalanced(String expr)
	{
	
	Stack<Character> stack
			= new Stack<Character>();
	
	// Reading the characters in Expression 
	for (int i = 0; i < expr.length(); i++)
	{
	 char ch = expr.charAt(i);

	if (ch == '(' || ch == '[' || ch == '{')
	{
		// Push the element in the stack
			stack.push(ch);
			continue; //move to next
	}

	// If current character is not opening
	// bracket, then it must be closing. So stack
	// cannot be empty at this point.
				
    if (stack.isEmpty())
		return false;
	
    char popch;
	
	switch (ch) {

	    case ')':
	       popch = stack.pop();
	       if (popch == '{' || popch == '[')
		    return false;
		   break;

		case '}':
			popch = stack.pop();
			if (popch == '(' || popch == '[')
			 return false;
			break;

		case ']':
		    popch = stack.pop();
		    if (popch == '(' || popch == '{')
			 return false;
			break;
		}//end switch
	}// end for

 // Check Empty Stack
	return (stack.isEmpty());
 }//end method checkingBracketsBalanced

// Driver code
 public static void main(String[] args)
  {
 	Boolean result;
 	String expression = "";
 	System.out.println("Hello Friends."+"\nThis is a program to check balanced bracketed strings\n");
 	System.out.println("\nSample Input Examples\n" +"A balanced Bracketed string is ([[{}]])\n" 
 	+ "An Unbalanced bracketed string is ([[{}]]))");
 	System.out.println("\nNow Lets Start ..." + "\n Please enter strings with brackets\n"+ 
 	"(Type QUIT/quit to exit the program)");
 	
  //result = checkingBracketsBalanced(expression);
 	Scanner sc = new Scanner(System.in);
 	expression = sc.next();
	while(!expression.equalsIgnoreCase("QUIT"))
	{
	 // call method to check balanced brackets
	 result = checkingBracketsBalanced(expression);		
	 if(result)
	  System.out.println("The entered string has Balanced brackets\n");
	 else
	  System.out.println("The entered string doesnot contain Balanced brackets\n");

	 System.out.println("\nPlease enter strings with brackets" + 
	 "(Type QUIT/quit to exit program)");
	 expression = sc.next();
	
	  }//end while
	System.out.println("Thanks. Program executed Successfully. Bye.");
     }//end main method
    }//end class BalancedBrackets
	