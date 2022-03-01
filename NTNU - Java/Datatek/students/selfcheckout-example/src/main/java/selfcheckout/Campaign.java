package selfcheckout;

import java.util.ArrayList;
import java.util.List;

public class Campaign {

    private String name;
    private double discount = 0.0;
    private String category;
    private boolean membersOnly;
    private List<String> activeWeekdays;

    public Campaign(String name, double discount, String category, boolean membersOnly, List<String> activeWeekdays) {
        this.name = name;
        this.discount = discount;
        this.category = category;
        this.membersOnly = membersOnly;
        this.activeWeekdays = new ArrayList<>(activeWeekdays);
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

    public String getCategory() {
        return category;
    }

    public boolean isMembersOnly() {
        return membersOnly;
    }

    public List<String> getActiveWeekdays() {
        return new ArrayList<>(activeWeekdays);
    }

    @Override
    public String toString() {
        return name + " -" + Math.round(discount * 100) + "%";
    }
}
