package oving2;

import java.util.regex.Pattern;

public class Vehicle {
    private char vehicle;
    private char fuel;
    private String regNr;
    private String[] allRegNr = {"EL", "EK", "HY"};
    
    public Vehicle(char vehicle, char fuel, String regNr) {
        if (vehicle == 'C' || vehicle == 'M') {
            this.vehicle = vehicle;
        } else throw new IllegalArgumentException("Not an available vehicle");
        if (fuel == 'H' || fuel == 'E' || fuel == 'D' || fuel == 'G') {
            this.fuel = fuel;
        } else throw new IllegalArgumentException("Not an available fuel");

        String subRegNr = regNr.substring(0, 2);

        if (this.vehicle == 'C') {
            if (this.fuel == 'H') {
                if (subRegNr.contains(allRegNr[2]) && (Pattern.matches("[A-Z]{2}[0-9]{5}", regNr))) {
                    this.regNr = regNr;
                } else throw new IllegalArgumentException();
            }
            else if (this.fuel == 'E') {
                if ((subRegNr.contains(allRegNr[1]) || subRegNr.contains(allRegNr[0])) && (Pattern.matches("[A-Z]{2}[0-9]{5}", regNr))) {
                    this.regNr = regNr;
                } else throw new IllegalArgumentException();
            } else {
                if (!(subRegNr.contains(allRegNr[0]) || subRegNr.contains(allRegNr[1]) || subRegNr.contains(allRegNr[2])) && (Pattern.matches("[A-Z]{2}[0-9]{5}", regNr)) && (Pattern.matches("[A-Z]{2}", subRegNr))) {
                    this.regNr = regNr;
                } else throw new IllegalArgumentException();
            }
        }

        else if (this.vehicle == 'M') {
            if (this.fuel == 'E') {
                if ((subRegNr.contains(allRegNr[1]) || subRegNr.contains(allRegNr[0])) && (Pattern.matches("[A-Z]{2}[0-9]{4}", regNr))) {
                    this.regNr = regNr;
                } else throw new IllegalArgumentException();
            } else {
                if (!(subRegNr.contains(allRegNr[0]) || subRegNr.contains(allRegNr[1]) || subRegNr.contains(allRegNr[2])) && (Pattern.matches("[A-Z]{2}[0-9]{4}", regNr)) && (Pattern.matches("[A-Z]{2}", subRegNr))) {
                    this.regNr = regNr;
                } else throw new IllegalArgumentException();
            }
        }
    }

    public char getFuelType() {
        return fuel;
    }

    public String getRegistrationNumber() {
        return regNr;
    }

    public char getVehicleType() {
        return vehicle;
    }

    public void setRegistrationNumber(String regNr) {
        String subRegNr = regNr.substring(0, 2);

        if (this.vehicle == 'C') {
            if (this.fuel == 'H') {
                if (subRegNr.contains(allRegNr[2]) && (Pattern.matches("[A-Z]{2}[0-9]{5}", regNr))) {
                    this.regNr = regNr;
                } else throw new IllegalArgumentException();
            }
            else if (this.fuel == 'E') {
                if ((subRegNr.contains(allRegNr[1]) || subRegNr.contains(allRegNr[0])) && (Pattern.matches("[A-Z]{2}[0-9]{5}", regNr))) {
                    this.regNr = regNr;
                } else throw new IllegalArgumentException();
            } else {
                if (!(subRegNr.contains(allRegNr[0]) || subRegNr.contains(allRegNr[1]) || subRegNr.contains(allRegNr[2])) && (Pattern.matches("[A-Z]{2}[0-9]{5}", regNr)) && (Pattern.matches("[A-Z]{2}", subRegNr))) {
                    this.regNr = regNr;
                } else throw new IllegalArgumentException();
            }
        }

        else if (this.vehicle == 'M') {
            if (this.fuel == 'E') {
                if ((subRegNr.contains(allRegNr[1]) || subRegNr.contains(allRegNr[0])) && (Pattern.matches("[A-Z]{2}[0-9]{4}", regNr))) {
                    this.regNr = regNr;
                } else throw new IllegalArgumentException();
            } else {
                if (!(subRegNr.contains(allRegNr[0]) || subRegNr.contains(allRegNr[1]) || subRegNr.contains(allRegNr[2])) && (Pattern.matches("[A-Z]{2}[0-9]{4}", regNr)) && (Pattern.matches("[A-Z]{2}", subRegNr))) {
                    this.regNr = regNr;
                } else throw new IllegalArgumentException();
            }
        }
    }


    @Override
    public String toString() {
        return "Vehicle [fuel=" + fuel + ", regNr=" + regNr + ", vehicle="
                + vehicle + "]";
    }

    public static void main(String[] args) {
        Vehicle car = new Vehicle('C', 'G', "ABC1234");
        System.out.println(car);
    }

}
