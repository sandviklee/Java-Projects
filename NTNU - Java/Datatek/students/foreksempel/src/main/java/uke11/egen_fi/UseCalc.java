package uke11.egen_fi;

import java.util.ArrayList;
import java.util.List;

public class UseCalc {

    private int x;
    private int y;

    public UseCalc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public long process(Calculator calc) {
        return calc.calculate(x, y);
    }
    public static void main(String[] args) {

        
        // Calculator calc1 = (x, y) -> x + y;
        // Calculator calc2 = (x, y) -> x * y;

        // System.out.println(calc1.calculate(3, 6));
        // System.out.println(calc2.calculate(3, 6));

        List<UseCalc> list = new ArrayList<>();
        list.add(new UseCalc(1, 2));
        list.add(new UseCalc(10, 20));
        list.add(new UseCalc(15, 100));

        // for (UseCalc useCalc : list) {
        //     System.out.println(useCalc.process((x, y) -> x + y));
        // }
        list.forEach(s ->System.out.println(s.process((x, y) -> x * y)));
    }
}
