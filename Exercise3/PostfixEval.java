import java.util.Scanner;


public class PostfixEval {
	public static void main(String args[]) {
		char operator;
		double left,right = 0.0;
		Scanner s = new Scanner(System.in);
		Scanner scan = new Scanner(s.nextLine());
		GenericStack<Double> stack = new GenericStack<Double>();
		while(scan.hasNext()) {
			if(scan.hasNextDouble()) {
				stack.push(scan.nextDouble());
			}
			else {
				operator = scan.next().charAt(0);
				if(stack.Empty()) {
					System.out.println("Not enough operands");
					System.exit(0);
				}	
				right = stack.pop();
				if(stack.Empty()) {
					System.out.println("Not enough operands");
					System.exit(0);
				}
				left = stack.pop();
				stack.push(evaluate(left,right,operator));
			}
		}
		System.out.println(stack.pop());
		scan.close();
		s.close();
	}
	public static double evaluate(double left, double right, char operator) {
		Calc<Double> c= new Calc<Double>();
		if(operator == '+') {
			return c.add(left,right);
		}
		else if(operator == '-') {
			return c.sub(left,right);
		}
		else if(operator == '*') {
			return c.mul(left,right);
		}
		else if(operator == '/') {
			if (right == 0) {
				System.out.println("Cannot divide by zero");
				System.exit(0);
			}
			return c.div(left,right);
		}
		else  {
			try {
				return c.pow(left, right);
			} catch (Exception e) {
				System.out.println("Invalid Operator");
				System.exit(0);
			}
		}
		return 0.0;
	}

}
