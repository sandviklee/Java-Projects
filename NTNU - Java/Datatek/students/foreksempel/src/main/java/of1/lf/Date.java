package of1.lf;

import java.util.ArrayList;
import java.util.List;

// Dette er LF til eksamen. Ikke vær bekymret om dere ikke forstår all syntaks.
// Her har vi laget hjelpemotodene "check" og "numberofdays" som gjør ting litt enklere.
public class Date {

    private int day, month, year;

    private ArrayList<Integer> longMonths = new ArrayList<>(List.of(1, 3, 5, 7, 8, 10, 12)); // Months of 31 days
    private ArrayList<Integer> shortMonths = new ArrayList<>(List.of(4, 6, 9, 11)); // Months of 30 days (notice that
                            

    public Date(int day, int month, int year) {
        check(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0));
    }

    private int numberOfDays(int month, int year) {
        if (longMonths.contains(this.month)) {
            return 31;
        }
        else if (shortMonths.contains(this.month)) {
            return 30;
        } 
        else if (month ==2){
            return (isLeapYear(year) ? 29 : 28); // Søk opp "ternary operator" for å finne ut hva denne gjor ;)
        }
        return -1;
    }

    private void check(int day, int month, int year) {
        if (day < 1 || day > numberOfDays(month, year)) {
            throw new IllegalArgumentException("day is illegal: " + day);
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("month is illegal: " + day);
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        check(day, month, year);
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        check(day, month, year);
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        check(day, month, year);
        this.year = year;
    }

    public void nextDay() {
        day++;
        if (day > numberOfDays(month, year)) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    public void previousDay() {
        day--;
        if (day < 1) {
            month--;
            if (month < 1) {
                month = 12;
                year--;
            }
            day = numberOfDays(month, year);
        }
    }
}
