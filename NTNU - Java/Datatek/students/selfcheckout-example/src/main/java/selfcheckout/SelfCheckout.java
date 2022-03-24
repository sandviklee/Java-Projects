package selfcheckout;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SelfCheckout {

    public static final List<String> days = Arrays.asList("mon", "tue", "wed", "thu", "fri", "sat", "sun");

    // Felter / Tilstand - del 1
    private String day;
    private boolean adminMode;
    private String password;
    private String phoneNumber;
    private List<Item> shoppingCart;
    private Collection<Campaign> campaigns;

    public SelfCheckout(String day, String password, List<Campaign> campaigns) {
        validateDay(day);
        validatePassword(password);
        this.day = day;
        this.password = password;
        this.adminMode = false;
        this.shoppingCart = new ArrayList<>();
        this.campaigns = new ArrayList<>(campaigns);
    }

    public List<Item> getShoppingCartItems() {
        return new ArrayList<>(this.shoppingCart);
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

    public void deactivateAdminMode() {
        if (!this.adminMode) {
            throw new IllegalStateException("Admin mode is already inactive!");
        }
        this.adminMode = false;
    }

    public void registerPhoneNumber(String phoneNumber) {
        if (this.phoneNumber != null) {
            throw new IllegalStateException("Illegal operation");
        }
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Not a valid phone number, please re-enter.");
        }
    }

    // Del 4 b)
    public boolean isMember() {
        return phoneNumber != null;
    }

    // Denne linja ble endret i uke 11 for å gi tilgang til phoneNumber eksternt.
    public String getPhoneNumber() {
        return this.phoneNumber;
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

    public List<String> getCartDisplayList() {
        List<String> displayList = new ArrayList<>();
        for (Item item : shoppingCart) {
            Campaign campaign = getCampaignForItem(item);
            if (campaign == null) {
                displayList.add(item.getName() + "\n" + String.format("%.2f", this.getPriceForItem(item)) + " kr");
            } else {
                displayList.add(item.getName() + "\n" + campaign + "\n"
                        + String.format("%.2f", this.getPriceForItem(item)) + " kr");
            }
        }
        return displayList;
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

    private Campaign getCampaignForItem(Item item) {
        for (Campaign campaign : campaigns) {
            if (campaign.isMembersOnly() && !isMember()) {
                continue;
            }

            if (!campaign.getActiveWeekdays().contains(day)) {
                continue;
            }

            if (campaign.getCategory() != null && !campaign.getCategory().equals(item.getCategory())) {
                continue;
            }
            return campaign;
        }
        return null;
    }

    // Del 5
    private double getDiscountForItem(Item item) {
        Campaign campaign = getCampaignForItem(item);
        if (campaign != null) {
            return campaign.getDiscount();
        } else {
            return 0.0;
        }
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
    private int getNumberOfEqualItemsInCart(Item item) {
        int equalItems = 0;
        for (Item cartItem : shoppingCart) {
            // Denne linjen ble endret for uke 11
            // Se Item.java og .equals-metoden for forklaring.
            if (item.equals(cartItem)) {
                equalItems++;
            }
        }
        return equalItems;
    }

    // Del 8 & 9
    @Override
    public String toString() {
        List<Item> uniqueItems = new ArrayList<>();
        String receipt = """
                -----------------------------------------------
                Hva                     Pris    MVA     Total
                """;
        for (Item item : shoppingCart) {
            // ArrayList.contains bruker object.equals internt,
            // Som gjør at vi sammenligner strenger på riktig måte
            if (!uniqueItems.contains(item)) {
                int count = this.getNumberOfEqualItemsInCart(item);
                // Denne linja ble endret i uke 11 for å gi bedre formattering i JavaFX:
                receipt += String.format("%dx %-20.20s %.2f\t%.2f\t%.2f\n",
                        count,
                        item.getName(),
                        this.getPriceWithoutMVAForItem(item),
                        this.getMVAForItem(item),
                        this.getPriceForItem(item) * count);
                uniqueItems.add(item);
            }
        }
        receipt += String.format(
                """
                        -----------------------------------------------
                        Total MVA                               %.2f
                        Total                                   %.2f
                                     Takk for at du handlet
                                         hos oss i OOP!
                        -----------------------------------------------
                        """,
                this.getTotalMVAForCart(),
                this.getTotalPriceForCart());
        return receipt;
    }

    public String getCheckoutText() {
        String text = "";
        if (isMember()) {
            text = String.format(
                    """
                            ---------------------------------------
                            Medlems-ID: %s
                            """, this.phoneNumber);
        }
        text += String.format(
                """
                        ---------------------------------------
                        Total MVA\t\t\t\t\t\t%.2f
                        Total\t\t\t\t\t\t\t%.2f
                        ---------------------------------------""",
                this.getTotalMVAForCart(),
                this.getTotalPriceForCart());
        return text;
    }

}
