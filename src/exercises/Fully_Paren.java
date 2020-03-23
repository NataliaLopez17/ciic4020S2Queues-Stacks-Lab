package exercises;

import java.util.Scanner;

import ciic4020.stack.ArrayStack;
import ciic4020.stack.Stack;

public class Fully_Paren {

	public static Integer[] theArray;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("please enter an expression and its corresponding values: ");
		String line = null;
		int i = 0;
		theArray = new Integer[26];
		while ((line = in.nextLine()).length() > 0) {
			if (line.substring(0) == "=") {
				String[] valuesArray = line.split("=");
				int ints = (int) valuesArray[0].charAt(0) - 65;
				theArray[ints] = Integer.parseInt(valuesArray[1]);
			}
			fullyParenthesizedExpression(line);
		}
		// fullyParenthesizedExpression(line);
	}

	public static boolean isOperator(char c) {
		return ((c == '/') || (c == '*') || (c == '+') || (c == '-'));
	}

	public static boolean isLowerPrecedence(char operand1, char operand2) {

		switch (operand1) {
		case '+':
		case '-':
			return !(operand2 == '+' || operand2 == '-');

		case '*':
		case '/':
			return operand2 == '(' || operand2 == '[' || operand2 == '{';

		case '(':
			return true;
		case '[':
			return true;
		case '{':
			return true;

		default:
			return false;
		}
	}

	public static String fullyParenthesizedExpression(String infix) {
		Stack<Character> operators = new ArrayStack<Character>(1);
		Stack<Character> operands = new ArrayStack<Character>(1);
		Stack<Character> parenthesis = new ArrayStack<Character>(1);
		Integer[] newArray = theArray;

		char[] infixArr = infix.toCharArray();
		for (int i = 0; i < infixArr.length; i++) {
			if (infixArr[i] == '=') {
				continue;
			}
		}
		for (int i = 0; i < infixArr.length; i++) {
			if (infixArr[i] == ':') {
				if ((infixArr[0] != '[' && infixArr[0] != '{' && infixArr[0] != '(')
						|| (infixArr[infixArr.length - 1] != ']' && infixArr[infixArr.length - 1] != '}')) {
					System.out.println(infix + " is invalid");
					break;
				}
				if (infixArr[i] == '(' || infixArr[i] == '{' || infixArr[i] == '[') {
					parenthesis.push(infixArr[i]);
				}
				if ((infixArr[i] >= 'A' && (infixArr[i] <= 'Z'))) {
					operands.push(infixArr[i]);
				}
				if (isOperator(infixArr[i])) {
					operators.push(infixArr[i]);
				} else {
					if (operators.isEmpty() || operands.size() < 2) {
						if (parenthesis.top() != infixArr[i]) {
							System.out.println(infix + " is invalid");
							break;
						}
					} else {
						int op1 = operands.pop();
						int op2 = operands.pop();
						char character = operators.pop();

						switch (character) {
						case '+':
							operands.push((char) (op1 + op2));
							break;
						case '-':
							operands.push((char) (op2 - op1));
							break;
						case '/':
							operands.push((char) (op2 / op1));
							break;
						case '*':
							operands.push((char) (op2 * op1));
							break;

						}
						// parenthesis.pop();

						if (i == infixArr.length - 1 && parenthesis.size() != 0) {
							System.out.println(infix + " is invalid");
							break;
						}

						while (!operators.isEmpty()) {
							char temp = 0;
							if (isLowerPrecedence(infixArr[i], operators.top())) {
								operators.push(infixArr[i]);
							}
							if (isLowerPrecedence(operators.top(), infixArr[i])) {
								temp = operators.pop();
								operators.push(infixArr[i]);
							}
						}
					}
				}

				while (infixArr[i] == ')') {
					if (!operators.isEmpty() && parenthesis.top() != '(') {
						operands.push(operators.pop());
					}
				}

				if (i == infixArr[infixArr.length - 1]) {
					if (!parenthesis.isEmpty() && !operands.isEmpty()) {
						operands.push(operators.pop());
						operands.push(parenthesis.pop());

					}
				}
			}
			System.out.println(operands.pop());
		}

		return infix;

	}

}
