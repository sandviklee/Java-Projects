package uke9.timeintervalinterface;

public class UseTime {
    public static void main(String[] args) {
        TimeInterval ti1 = new TimeInterval1(14, 15, 16, 00);
        TimeInterval ti2 = new TimeInterval2(14, 15, 16, 00);
        TimeInterval ti3 = new TimeInterval3(14, 15, 16, 00);

        System.out.println(ti1.getDuration());
        System.out.println(ti2.getDuration());
        System.out.println(ti3.getDuration());
    }
}
