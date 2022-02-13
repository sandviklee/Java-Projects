package of3.lf;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SelfServiceCheckout {

    public static final List<String> days = Arrays.asList("mon", "tue", "wed", "thu", "fri", "sat", "sun");

    // Felter / Tilstand - del 1
    private String day;
    private boolean adminMode;
    private String password;
    private String phoneNumber;
    private List<Item> shoppingCart;

    public SelfServiceCheckout(String day, String password) {
        validateDay(day);
        validatePassword(password);
        this.day = day;
        this.password = password;
        this.adminMode = false;
        this.shoppingCart = new ArrayList<>();
    }

    // Del 4 a)
    public void removeFromCart(int index) {
        if (!this.adminMode) {
            throw new IllegalStateException("Illegal operation");
        }
        this.shoppingCart.remove(index);
    }

    // Del 2 a)
    public void activateAdminMode(String password) {
        if (this.adminMode) {
            throw new IllegalStateException("Admin mode is already active!");
        }
        if (this.password.equals(password)) {
            this.adminMode = true;
        } else {
            throw new IllegalArgumentException("Wrong password, permission denied");
        }
    }

    public void registerPhoneNumber(String phoneNumer) {
        if (this.phoneNumber != null) {
            throw new IllegalStateException("Illegal operation");
        }
        if (isValidPhoneNumber(phoneNumer)) {
            this.phoneNumber = phoneNumer;
        } else {
            throw new IllegalArgumentException("Not a valid phone number, please re-enter.");
        }
    }

    // Del 4 b)
    public boolean isMember() {
        return phoneNumber != null;
    }

    // Del 3
    public void scanItem(Item item) {
        this.shoppingCart.add(item);
        System.out.println(item.getName() + ": " + item.getPrice() + "kr");
    }

    public void scanItems(List<Item> shoppingCart) {
        for (Item i : shoppingCart) {
            scanItem(i);
        }
    }

    // Metodene nedenfor er alle "private" da de kun er hjelpe/valideringsmetoder
    // Dette betyr at vi ikke har bruk for de utenfor klassen og vi gjør de derfor
    // heller ikke synlige utenfor.

    // Fra forrige uke
    private void validateDay(String day) {
        if (!days.contains(day)) {
            throw new IllegalArgumentException("Invalid weekday");
        }
    }

    // Del 5
    private double getDiscountForItem(Item item) {
        // Funksjonaliteten her skal vi utvide senere...
        if (isMember() && item.getCategory().equals("taco")) {
            if (day == "fri" || day == "sat") {
                return 0.3;
            }
        }
        return 0.0;
    }

    private double getPriceForItem(Item item) {
        return item.getPrice() - (item.getPrice() * this.getDiscountForItem(item));
    }

    // Del 6
    private double getMVAForItem(Item item) {
        return this.getPriceForItem(item) * 0.15;
    }

    private double getPriceWithoutMVAForItem(Item item) {
        return this.getPriceForItem(item) - this.getMVAForItem(item);
    }

    // Del 7
    private double getTotalPriceForCart() {
        double sum = 0;
        for (Item item : shoppingCart) {
            sum += this.getPriceForItem(item);
        }
        return sum;
    }

    private double getTotalMVAForCart() {
        double totalMVA = 0;
        for (Item item : shoppingCart) {
            totalMVA += this.getMVAForItem(item);
        }
        return totalMVA;
    }

    // Del 2 b)
    private boolean validatePassword(String password) {
        // Eventuelt kan man her bare bruke
        // password.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{6,10}$"); som jeg brukte i
        // forelesning
        // Dette uttrykket kalles RegEx og kan være noe utfordrende å skrive på egenhånd
        // Det finnes dog en rekke gode ressurser på nett hvis man søker litt rundt.
        // Nedenfor har jeg beskrevet en mer "manuell" metode som løses med vanlig
        // Java-kode.
        if (password.length() < 6 || password.length() > 10) {
            return false;
        }
        char[] chars = password.toCharArray();
        boolean containsNumeric = false;
        boolean containsAlphabetic = false;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                containsNumeric = true;
            } else if (Character.isAlphabetic(c)) {
                containsAlphabetic = true;
            }
        }
        return containsAlphabetic && containsNumeric;
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

    // Del 9
    private int getNumberOfEqualItemsInCart(String barcode) {
        int equalItems = 0;
        for (Item item : shoppingCart) {
            if (item.getBarcode().equals(barcode)) {
                equalItems++;
            }
        }
        return equalItems;
    }

    // Del 8 & 9
    @Override
    public String toString() {
        List<String> uniqueBarcodes = new ArrayList<>();
        String receipt = """
                --------------------------------------
                Hva             Pris    MVA     Total
                """;
        for (Item item : shoppingCart) {
            // ArrayList.contains bruker object.equals internt,
            // Som gjør at vi sammenligner strenger på riktig måte
            if (!uniqueBarcodes.contains(item.getBarcode())) {
                int count = this.getNumberOfEqualItemsInCart(item.getBarcode());
                receipt += String.format("%dx %s\t%.2f\t%.2f\t%.2f\n",
                        count,
                        item.getName(),
                        this.getPriceWithoutMVAForItem(item),
                        this.getMVAForItem(item),
                        this.getPriceForItem(item) * count);
                uniqueBarcodes.add(item.getBarcode());
            }
        }
        receipt += String.format(
                """
                        --------------------------------------
                        Total MVA                       %.2f
                        Total                           %.2f
                                Takk for at du handlet
                                    hos oss i OOP!
                        --------------------------------------
                        """,
                this.getTotalMVAForCart(),
                this.getTotalPriceForCart());
        return receipt;
    }

    // main-metode for å teste koden
    public static void main(String[] args) {

        SelfServiceCheckout checkout = new SelfServiceCheckout("fri", "passord123");

        Item tomato = new Item("Tomat", 5, "fruit", "|| ||| | |||| |");
        Item cheese = new Item("Norvegia", 90, "diary", "| | ||||| | |||");
        Item cheese2 = new Item("Norvegia", 90, "diary", "| | ||||| | |||");
        Item tortillas = new Item("Lefser", 15, "taco", " | || | || ||||");
        Item groundMeat = new Item("Kjøttdeig", 29.99, "taco", "|||| || | |||||");

        checkout.scanItem(tomato);
        checkout.scanItem(cheese);
        checkout.scanItem(tortillas);
        checkout.scanItem(groundMeat);
        checkout.scanItem(cheese2);

        System.out.println(checkout);

        checkout.registerPhoneNumber("004742345678");
        checkout.activateAdminMode("passord123");
        checkout.removeFromCart(0);

        System.out.println(checkout);

    }

}
