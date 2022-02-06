package of3.kode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.EventDispatchChain;

public class SelfServiceCheckout {

    public static final List<String> days = Arrays.asList("mon", "tue", "wed", "thu", "fri", "sat", "sun");

    private boolean adminMode;
    private String password;
    private String day;
    private String phoneNumber;
    private List<Item> shoppingCart;

    public SelfServiceCheckout(String day, String password) {
        validateDay(day);
        validatePassword(password);
        this.day = day;
        this.adminMode = false;
        this.password = password;
        this.shoppingCart = new ArrayList<>();
    }

    public void activateAdminMode() {
        if (this.adminMode) {
            throw new IllegalStateException("Du er allerede logget inn som admin!");
        }

        if (this.password.equals(password)) {
            this.adminMode = true;
        }
        else {
            throw new IllegalArgumentException("Feil Passord.");
        }
    }

    private void validateDay(String day) {
        if (!days.contains(day)) {
            throw new IllegalArgumentException("Invalid weekday");
        }
    }

    private void validatePassword(String password) {
        if (!password.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{6,10}$")) {
            throw new IllegalArgumentException();
        }
    }

    public void registerPhoneNumber(String phoneNumber) {
        if (this.phoneNumber != null) {
            /*
             * Her kaster vi IllegalStateException og ikke IllegalArgumentException
             * fordi argumentet i seg selv (telefonnummeret) kan være gyldig, men
             * det er ikke en gyldig tilstand å sette et nytt telefonnummer på nytt
             * når brukeren allerede har registrert et fra før
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

    public void scanItem(Item item) {
        this.shoppingCart.add(item);
        System.out.println(item.getName() + ": " + item.getPrice() + " kr");
    }

    public void scanItems(List<Item> items) {
        for (Item item : items) {
            scanItem(item);
        }
    }

    public void removeFromCart(int index) {
        if (!this.adminMode) {
            throw new IllegalStateException("Du kan ikke fjerne varer.");
        }
        else this.shoppingCart.remove(index);
        
    }

    public boolean isMember() {
        return this.phoneNumber != null;
    }

    public double getDiscountForItem(Item item) {
        if (isMember() && item.getCategory().equals("taco")) {
            if (this.day.equals("fri") || this.day.equals("sat")) {
                return 0.3;
            }
        }
        return 0.0;
    }

    public double getPriceForItem(Item item) {
        return item.getPrice() - (item.getPrice()*getDiscountForItem(item));
    }

    public double getMVAForItem(Item item) {
        double MVA = 1.15;
        return item.getPrice() - item.getPrice()/(MVA);
    }

    public double getPriceWithoutMVAForItem(Item item) {
        return item.getPrice() - this.getMVAForItem(item);
    }

    public double getTotalMVAForCart() {
        double MVA = 0;
        for (Item item : shoppingCart) {
            MVA += this.getMVAForItem(item);
        }
        return MVA;
    }

    public double getTotalPriceForCart() {
        double sum = 0;
        for (Item item : shoppingCart) {
            sum += this.getPriceForItem(item);
        }
        return sum;
    }
    
    @Override
    public String toString() {
        String receipt = """
                --------------------------------------
                Hva             Pris    MVA     Total
                """;

        // TODO: Skriv kode for å printe ut varer og pris
        // Hint: Du kan bruke følgende streng med format-funksjonen:
        for (Item item : this.shoppingCart) {
            receipt += String.format("%dx %s\t%.2f\t%.2f\t%.2f\n", 1, item.getName(), this.getPriceForItem(item), this.getMVAForItem(item), this.getPriceForItem(item));
        }

        // "%dx %s\t%.2f\t%.2f\t%.2f"

        /*
         * Forklaring:
         * %d representerer et heltall
         * %s representerer en streng
         * %.2f representerer et flyttall (og runder av til 2 desimaler)
         * \t representerer tabulator (å trykke på tab)
         */

        receipt += String.format(
                """
                        --------------------------------------
                        Total MVA                       %.2f
                        Total                           %.2f
                                Takk for at du handlet
                                    hos oss i OOP!
                        --------------------------------------
                        """, this.getTotalMVAForCart(), this.getTotalPriceForCart());
        return receipt;
    }

    // main-metode for å teste koden
    public static void main(String[] args) {

        Item tomato = new Item("Tomat", 5, "fruit", "|| ||| | |||| |");
        Item cheese = new Item("Norvegia", 90, "diary", "| | ||||| | |||");
        Item cheese2 = new Item("Norvegia", 90, "diary", "| | ||||| | |||");
        Item tortillas = new Item("Lefser", 15, "taco", " | || | || ||||");
        Item groundMeat = new Item("Kjøttdeig", 29.99, "taco", "|||| || | |||||");

        SelfServiceCheckout checkout = new SelfServiceCheckout("fri", "passord123");




        checkout.scanItem(tomato);
        checkout.scanItem(cheese);
        checkout.scanItem(tortillas);
        checkout.scanItem(groundMeat);
        checkout.scanItem(cheese2);

        System.out.println(checkout);

        // checkout.registerPhoneNumber("004742345678");
        // checkout.activateAdminMode("passord123");
        // checkout.removeFromCart(0);

        // System.out.println(checkout);
    }

}
