package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
	static String[] wholeNumber1;
	static String[] wholeNumber2;
	static String[] fraction1;
	static String[] fraction2;
	static String operation;
	static String menu;
	static String sign;
	static String outp;
	static String negative;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the World's Greatest Fraction Calculator!");
		mainMenu();
	}
	
	public static void mainMenu() throws IOException {
		System.out.println("Type in an action to begin. 'Help' gives you the list. ");
		System.out.println("Available actions: 'Reduce Fraction', 'Fraction Math', 'Exit'.");
		System.out.print("REMEMBER: Do not use spaces in your fraction input (even after the comma) unless it is for a mixed fraction! ");
		prompt();
	}
	
	public static void reduce() throws IOException {
		System.out.println("Available actions: 'Main Menu', 'Fraction Math', 'Exit'.");
		System.out.print("Enter in a fraction, Like 5/6 or 2 7/4, or change menus ('help'). ");
		String input = prompt().toLowerCase();
			System.out.println("Input: " + input);
			
			String sig;
			String official = input;
			
			int whole = 0;
			double wholed = 0;
			if (input.contains("-")) {
				official = input.replace("-", "");
				sig = "-";
			}
			else {
				sig = "";
			}
			if (input.contains(" ")) {
				wholeNumber1 = official.split(" ");
				fraction1 = wholeNumber1[1].split("/");
				whole = Integer.parseInt(wholeNumber1[0]);
				wholed = whole;
			}
			else {
				fraction1 = official.split("/");
			}
			
			int top = Integer.parseInt(fraction1[0]);
			int bottom = Integer.parseInt(fraction1[1]);
			double topd = top;
			double bottomd = bottom;
			
			if (top > bottom) {
				for (int i = bottom; i > 0; i--) {
					if (bottom % i == 0 && top % i == 0) {
						if (wholeNumber1 != null) {
							top /= i;
							bottom /= i;
							System.out.println("Output: " + sig + (whole + (top / bottom)) + " " + (top % bottom) / i + "/" + bottom / i + 
									", or " + sig + (wholed + (topd / bottomd)));
						}
						else {
							System.out.println("Output: " + sig + top / bottom + " " + (top % bottom) / i + "/"
						+ bottom / i+ ", or " + sig + topd / bottomd + " ");
						}
						break;
					}
				}
				
			}
			else if (bottom >= top) {
				for (int i = top; i > 0; i--) {
					if (bottom % i == 0 && top % i == 0) {
						if (wholeNumber1 != null) {
							System.out.println("Output: " + sig + whole + " " + top / i + "/" + bottom / i + ", or " + sig + (whole + (topd / i) / (bottomd / i)));
						}
						else {
							System.out.println("Output: " + sig + top / i + "/" + bottom / i + 
									", or " + sig + (topd / i) / (bottomd / i));
						}
						break;
					}
				}
			}
			else {
				System.out.println("Please enter a valid fraction");
				reduce();
			}
			reduce();
		}
	
	public static void math() throws IOException {
		System.out.println("Available actions: 'Main Menu', 'Reduce Fraction', 'Add', 'Subtract', 'Multiply', 'Divide', 'Exit'.");
		System.out.println("Now type in 'add', 'subtract', 'multiply', or 'divide'. Or you can change menus ('help'). ");
		System.out.print("WARNING: Once you enter an operation you cannot change menus until you finish the math! ");
		prompt();
	}
	
	public static void enter() throws IOException {
		System.out.print("Enter in two fractions exactly in this format: '3/4,3 7/6' ");
		String input = prompt().toLowerCase();
		
		int whole1 = 0;
		int whole2 = 0;
		
		String[] tempp = null;
		
		tempp = input.split(",");
		if (tempp[0].contains(" ")) {
			wholeNumber1 = tempp[0].split(" ");
			fraction1 = wholeNumber1[1].split("/");
			whole1 = Integer.parseInt(wholeNumber1[0]);
		}
		else {
			fraction1 = tempp[0].split("/");
		}
		if (tempp[1].contains(" ")) {
			wholeNumber2 = tempp[1].split(" ");
			fraction2 = wholeNumber2[1].split("/");
			whole2 = Integer.parseInt(wholeNumber2[0]);
		}
		else {
			fraction2 = tempp[1].split("/");
		}
		
		int top = 0;
		int bottom = 0;
		int whole = 0;
		double topd = 0;
		double bottomd = 0;
		int wholed = 0;
		
		int top1 = Integer.parseInt(fraction1[0]);
		int bottom1 = Integer.parseInt(fraction1[1]);
		int top2 = Integer.parseInt(fraction2[0]);
		int bottom2 = Integer.parseInt(fraction2[1]);
		
		System.out.println("Operation: " + operation);
		
		if (whole1 > 0 && whole2 > 0) {
			System.out.println("Input: " + whole1 + " " + top1 + "/" + bottom1 + ", " + whole2 + " " + top2 + "/" + bottom2);
			outp = "Output: " + whole1 + " " + top1 + "/" + bottom1 + " " + sign + " " + whole2 + " " + top2
					+ "/" + bottom2 + " = ";
		}
		else if (whole1 > 0 && whole2 <=0) {
			System.out.println("Input: " + whole1 + " " + top1 + "/" + bottom1 + ", " + top2 + "/" + bottom2);
			outp = "Output: " + whole1 + " " + top1 + "/" + bottom1 + " " + sign + " " + top2
					+ "/" + bottom2 + " = ";
		}
		else if (whole1 <= 0 && whole2 > 0) {
			System.out.println("Input: " + top1 + "/" + bottom1 + ", " + whole2 + " " + top2 + "/" + bottom2);
			outp = "Output: " + top1 + "/" + bottom1 + " " + sign + " " + whole2 + " " + top2
					+ "/" + bottom2 + " = ";
		}
		else {
			System.out.println("Input: " + top1 + "/" + bottom1 + ", " + top2 + "/" + bottom2);
			outp = "Output: " + top1 + "/" + bottom1 + " " + sign + " " + top2
					+ "/" + bottom2 + " = ";
		}
		
		int tempo;
		
		tempo = bottom1;
		top1 *= bottom2;
		bottom1 *= bottom2;
		top2 *= tempo;
		bottom2 *= tempo;
		
		if (bottom1 != bottom2 && operation != "multiply" && operation != "divide") {
			if (bottom1 > bottom2) {
				for (int i = bottom2; i > 0; i--) {
						if (bottom2 * i == bottom1) {
							bottom2 *= i;
							top2 *= i;
						}
				}
			}
			else if (bottom2 > bottom1){
				for (int i = bottom1; i > 0; i--) {
					if (bottom1 * i == bottom2) {
						bottom1 *= i;
						top1 *= i;
					}
				}
			}
		}
		
		if (operation == "add") {
			if (whole1 + whole2 < 0) {
				whole = (whole1 + whole2) * -1;
				negative = "-";
			}
			else {
				whole = (whole1 + whole2);
				negative = "";
			}
			if (top1 + top2 < 0) {
				top = (top1 + top2) * -1;
				negative = "-";
			}
			else {
				top = top1 + top2;
				negative = "";
			}
			if (bottom1 < 0) {
				bottom = bottom1 * -1;
				if (negative == "-")
					negative = "";
				else
					negative = "-";
			}
			else {
				bottom = bottom1;
				if (negative == "-")
					negative = "-";
				else
					negative = "";
			}
			topd = top;
			bottomd = bottom;
			whole = whole1 + whole2;
			wholed = whole;
			if (whole > 0) {
				top = bottom * whole + top;
			}
		}
		else if (operation == "subtract") {
			if (whole1 - whole2 < 0) {
				whole = (whole1 - whole2) * -1;
				negative = "-";
			}
			else {
				whole = (whole1 - whole2);
				negative = "";
			}
			if (top1 - top2 < 0) {
				top = (top1 - top2) * -1;
				negative = "-";
			}
			else {
				top = top1 - top2;
				negative = "";
			}
			if (bottom1 < 0) {
				bottom = bottom1 * -1;
				if (negative == "-")
					negative = "";
				else
					negative = "-";
			}
			else {
				bottom = bottom1;
				if (negative == "-")
					negative = "-";
				else
					negative = "";
			}
			topd = top;
			bottomd = bottom;
			whole = whole1 - whole2;
			wholed = whole;
			if (whole > 0) {
				top = bottom * whole + top;
			}
		}
		else if (operation == "multiply") {
			if (whole1 * whole2 < 0) {
				whole = (whole1 * whole2) * -1;
				negative = "-";
			}
			else {
				whole = (whole1 * whole2);
				negative = "";
			}
			if (top1 * top2 < 0) {
				top = (top1 * top2) * -1;
				negative = "-";
			}
			else {
				top = top1 * top2;
				negative = "";
			}
			if (bottom1 < 0) {
				bottom = (bottom1 * bottom2) -1;
				if (negative == "-")
					negative = "";
				else
					negative = "-";
			}
			else {
				bottom = bottom1 * bottom2;
				if (negative == "-")
					negative = "-";
				else
					negative = "";
			}
			whole = whole1 * whole2;
			topd = top;
			bottomd = bottom;
			whole = whole1 * whole2;
			wholed = whole;
			if (whole > 0) {
				top = bottom * whole + top;
			}
		}
		else if (operation == "divide") {
			int temp;
			if (top1 * bottom2 < 0) {
				top = (top1 * bottom1) * -1;
				negative = "-";
			}
			else {
				top = top1 * bottom2;
				negative = "";
			}
			if (bottom1 < 0) {
				bottom = (bottom1 * top2) * -1;
				if (negative == "-")
					negative = "";
				else
					negative = "-";
			}
			else {
				bottom = bottom1 * top2;
				if (negative == "-")
					negative = "-";
				else
					negative = "";
			}
			temp = top2;
			top2 = bottom2;
			bottom2 = temp;
			if (whole2 > 0) {
				whole = whole1 / whole2;
			}
			else {
				whole = whole1;
			}
			wholed = whole;
			if (whole > 0) {
				top = bottom * whole + top;
			}
			
//			top = top1 * top2;
//			bottom = bottom1 * bottom2;
			topd = top;
			bottomd = bottom;
		}
		doStuff(top, bottom, topd, bottomd, whole, wholed);
		math();
	}
	
	public static void doStuff(int t, int b, double td, double bd, int w, double wd) {
		if (t > b) {
			int top = t % b;
			int bot = b;
			
			for (int i = b; i > 0; i--) {
				if (top % i == 0 && bot % i == 0) {
					if (wholeNumber1 != null) {
						System.out.println(outp + negative + (w + (t - (b * w + top)) / b) + " " + top / i + "/" + b / i + ", or " + negative + (w + (td / i) / (bd / i)));
					}
					else {
					System.out.println(outp + negative + t / b + " " + top / i + "/" + b / i + ", or " + negative + td / bd + " ");
					}
					break;
				}
			}
		}
		else if (b >= t) {
			for (int i = t; i > 0; i--) {
				if (b % i == 0 && t % i == 0) {
					if (wholeNumber1 != null) {
						if (w > 0) {
							System.out.println(outp + negative + w + "" + t / i + "/" + b / i + ", or " + negative + (td / i) / (bd / i));
						}
						else {
							System.out.println(outp + negative +  t / i + "/" + b / i + ", or " + negative + (td / i) / (bd / i));
						}
					}
					else {
						System.out.println(outp + negative + t / i + "/" + b / i + ", or " + negative + (td / i) / (bd / i));
					}
					break;
				}
			}
		}
	}
	
	public static String prompt() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String answer = reader.readLine().toLowerCase();
		
		switch (answer) {
		case "help":
			if (menu == "math") {
				System.out.print("'Reduce Fraction', 'Fraction Math', 'Main Menu', 'add', 'subtract', 'multiply', 'divide', 'Exit'. ");
			}
			else {
				System.out.print("'Reduce Fraction', 'Fraction Math', 'Main Menu', 'Exit'. ");
			}
			prompt();
			break;
		case "main menu":
			menu = "";
			operation = null;
			System.out.println("Moving to Main Menu...");
			mainMenu();
			break;
		case "exit":
			System.out.print("Closing application...");
			break;
		case "reduce fraction":
			operation = null;
			menu = "reduce";
			System.out.println("Moving to 'Reduce Fraction'...");
			reduce();
			break;
		case "fraction math":
			menu = "math";
			operation = null;
			System.out.println("Moving to 'Fraction Math'...");
			math();
			break;
		case "add":
			if (menu == "math") {
			operation = "add";
			sign = "+";
			enter();
			}
			else {
				System.out.println("You are not in the right menu to do this. ");
				prompt();
			}
			break;
		case "subtract":
			if (menu == "math") {
			operation = "subtract";
			sign = "-";
			enter();
			}
			else {
				System.out.println("You are not in the right menu to do this. ");
				prompt();
			}
			break;
		case "multiply":
			if (menu == "math") {
			operation = "multiply";
			sign = "*";
			enter();
			}
			else {
				System.out.println("You are not in the right menu to do this. ");
				prompt();
			}
			break;
		case "divide":
			if (menu == "math") {
			operation = "divide";
			sign = "/";
			enter();
			}
			else {
				System.out.println("You are not in the right menu to do this. ");
				prompt();
			}
			break;
		default:
			if (menu == "math" && operation != null) {
				
			}
			else if (menu == "reduce") {
				
			}
			else {
				System.out.print("Not a valid action.");
				prompt();
			}
			break;
		}
		return answer;
	}
}
