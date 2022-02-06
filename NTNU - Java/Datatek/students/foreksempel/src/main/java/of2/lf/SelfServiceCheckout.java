package of2.lf;

import java.util.Arrays;
import java.util.List;

public class SelfServiceCheckout {

    // Del 1
    public static final List<String> days = Arrays.asList("mon", "tue", "wed", "thu", "fri", "sat", "sun");

    private String day;
    private String phoneNumber;

    // Del 2
    public SelfServiceCheckout(String day) {
        validateDay(day);
        this.day = day;
    }

    private void validateDay(String day) {
        if (!days.contains(day)) {
            throw new IllegalArgumentException("Invalid weekday");
        }
    }

    // Del 3
    public void registerPhoneNumber(String phoneNumber) {
        if (this.phoneNumber != null) {
            /*
             * Her kaster vi IllegalStateException og ikke IllegalArgumentException
             * fordi argumentet i seg selv (telefonnummeret) kan være gyldig, men
             * det er ikke en gyldig tilstand å sette et nytt telefonnummer på nytt
             * når brukeren allerede har registrert et fra før-
             */
            throw new IllegalStateException("Illegal operation: Phone number already registered");
        }
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Not a valid phone number!");
        }
        this.phoneNumber = phoneNumber;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String cleanedPhoneNumber = phoneNumber.replaceAll("\\s", "");
        if (cleanedPhoneNumber.startsWith("00479") || cleanedPhoneNumber.startsWith("00474")) {
            if (cleanedPhoneNumber.length() != 12) {
                return false;
            }
        } else if (cleanedPhoneNumber.startsWith("+479") || cleanedPhoneNumber.startsWith("+474")) {
            if (cleanedPhoneNumber.length() != 11) {
                return false;
            }
        } else {
            return false;
        }

        // Her kunne man også fjernet første tegn i charArrayen og sjekket resten
        // Dette kan vi gjøre siden vi allerede har validert de første 4-5 tegnene
        char[] chars = cleanedPhoneNumber.toCharArray();
        boolean firstIndex = true;
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                if (c != '+' && !firstIndex) {
                    return false;
                }
                firstIndex = false;
            }
        }

        return true;
    }

    // Del 4
    public void scanItem(String itemName, int amount, double price) {
        double rebate = 0.0;
        if (phoneNumber != null && day.equals("thu")) {
            rebate = 0.1;
        }
        System.out.println(amount + "x " + itemName + ": " + (price - (price * rebate)) + " kr");
    }

    // Testkode / main-metode
    public static void main(String[] args) {
        SelfServiceCheckout checkout = new SelfServiceCheckout("thu");
        checkout.scanItem("Norvegia", 2, 120.0);
        checkout.registerPhoneNumber("004742345678");
        checkout.scanItem("Tomat", 3, 5.0);
    }

}
