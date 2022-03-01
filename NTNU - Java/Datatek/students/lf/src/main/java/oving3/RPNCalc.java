package oving3;

import java.util.Stack;

public class RPNCalc {

	private Stack<Double> operandStack;

	public RPNCalc() {
		operandStack = new Stack<Double>();
	}

	public void push(double value) {
		operandStack.push(value);
	}

	public int getSize() {
		return operandStack.size();
	}

	public double peek(int n) {
		if (n < 0 || operandStack.size() <= n) {
			return Double.NaN;
		}

		return operandStack.get(operandStack.size() - n - 1);
	}

	public double pop() {
		return this.pop(Double.NaN);
	}

	public double pop(double defaultValue) {
		if (operandStack.isEmpty()) {
			return defaultValue;
		}

		return operandStack.pop();
	}

	// perform the operation denoted by op
	// each operation pops and pushes values off and onto the operand stack,
	public void performOperation(char op) {
		double d1, d2;
		switch (op) {
			case '+':
				// pop two operands and push the sum, missing values default to 0.0
				d1 = pop(0.0);
				d2 = pop(0.0);
				push(d2 + d1);
				break;
			case '-':
				// pop two operands and push the difference, missing values default to 0.0
				d1 = pop(0.0);
				d2 = pop(0.0);
				push(d2 - d1);
				break;
			case '*':
				// pop two operands and push the product, missing values default to 1.0
				d1 = pop(1.0);
				d2 = pop(1.0);
				push(d2 * d1);
				break;
			case '/':
				// pop two operands and push the quotient, missing values default to 1.0
				d1 = pop(1.0);
				d2 = pop(1.0);
				push(d2 / d1);
				break;
			// dup
			case ',':
				d1 = pop(0.0);
				// push back twice
				push(d1);
				push(d1);
				break;
			// pop
			case '.':
				// remove the topmost value
				pop(0.0);
				break;
			// swap
			case '~':
				// swap the two topmost values, by popping them and pushing them in reverse
				// order
				d1 = pop(0.0);
				d2 = pop(0.0);
				push(d1);
				push(d2);
				break;
			// extra operators
			// remainder
			case '%':
				d1 = pop(1.0);
				d2 = pop(1.0);
				push(d2 % d1);
				break;
			// absolute
			case '|':
				push(Math.abs(pop(0.0)));
				break;
			// square root
			case 'v':
				push(Math.sqrt(pop(1.0)));
				break;
			// power of
			case '^':
				d1 = pop(1.0);
				d2 = pop(1.0);
				push(Math.pow(d2, d1));
				break;
			// floor
			case '_':
				double d = pop(0.0);
				push(Math.floor(d));
				break;
			// compare
			case '=':
				d1 = pop(1.0);
				d2 = pop(1.0);
				push(Double.compare(d2, d1));
				break;
			// signum
			case '?':
				push(Math.signum(pop(0.0)));
				break;
			// pi
			case 'p':
			case 'π':
				push(Math.PI);
				break;
			// e
			case 'e':
				push(Math.exp(1.0));
				break;
		}
	}

	@Override
	public String toString() {
		return operandStack.toString();
	}
}
