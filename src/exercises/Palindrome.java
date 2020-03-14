package exercises;

import java.util.Scanner;

import ciic4020.queue.DoublyLinkedQueue;
import ciic4020.queue.Queue;
import ciic4020.stack.LinkedListStack;
import ciic4020.stack.Stack;

public class Palindrome {
	
	public static void main(String[] args) {
		
		Scanner scanObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.print("Please enter a string: ");

	    String string = scanObj.nextLine();  // Read user input
	    isPalindrome(string);
	    
	    if(isPalindrome(string)) {
	    	System.out.println("Palindrome");
	    }
	    else {
	    	 System.out.println("Not a Palindrome");
	    }
	   
	    scanObj.close();
	}
	
	public static boolean isPalindrome(String palindrome) {
		palindrome = palindrome.replaceAll("[^A-Za-z]+", "").toLowerCase();
		
		Queue<String> newQueue = new DoublyLinkedQueue<String>();
		Stack<String> newStack = new LinkedListStack<String>();
		
		
		return false;
		
	}


}
