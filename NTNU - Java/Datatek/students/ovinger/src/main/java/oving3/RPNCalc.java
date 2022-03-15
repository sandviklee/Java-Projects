package oving3;

import java.util.ArrayList;

public class RPNCalc {
    private ArrayList<Double> integers = new ArrayList<>();
    double sum;

    public RPNCalc() {
        
    }

    public void push(double n) {
        integers.add(n);
    }

    public double pop() {
        if (integers.isEmpty()) {
            return Double.NaN;
        }
        else {
            double doubleAtTop = integers.get(integers.size()-1);
            integers.remove(integers.size()-1);
            return doubleAtTop;
        }
    }

    public double peek(int n) {
        if (integers.size() > Math.abs(n)) {
            return integers.get((integers.size()-1) - n);
        } 
        else {
            return Double.NaN;
        }
    }

    public int getSize() {
        return integers.size();
    }

    public void performOperation(char n) {
        try {
            if (n == '+') {
                double integer1 = this.peek(0);
                this.pop();
                double integer2 = this.peek(0);
                sum = integer2 + integer1;
                this.pop();
                this.push(sum);
            }
            else if (n == '-') {
                double integer1 = this.peek(0);
                this.pop();
                double integer2 = this.peek(0);
                sum = integer2 - integer1;
                this.pop();
                this.push(sum);         
            }
            else if (n == '*') {
                double integer1 = this.peek(0);
                this.pop();
                double integer2 = this.peek(0);
                sum = integer2 * integer1;
                this.pop();
                this.push(sum);         
            }
            else if (n == '/') {
                double integer1 = this.peek(0);
                this.pop();
                double integer2 = this.peek(0);
                sum = integer2 / integer1;
                this.pop();
                this.push(sum);       
            }
            else if (n == '~') {
                double integer1 = this.peek(0);
                this.pop();
                double integer2 = this.peek(0);
                this.pop();
                this.push(integer1);
                this.push(integer2);
            }
            else if (n == 'p' || n == 'π') {
                this.push(Math.PI);
            }
            else if (n == '|') {
                double integer1 = Math.abs(this.peek(0));
                this.pop();
                this.push(integer1);
            }
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("Operanden din er ikke mulig.");
        }
    }

    public static void main(String[] args) {
        RPNCalc rpn = new RPNCalc();
        rpn.push((double) 2);
        rpn.push((double) 3);
        rpn.push((double) 6);
        rpn.push((double) 9);
        rpn.performOperation('+');
        System.out.println(rpn.getSize());
        rpn.performOperation('+');
        System.out.println(rpn.getSize());
        rpn.performOperation('*');
        System.out.println(rpn.getSize());
        System.out.println(rpn.peek(0));
    }

}
