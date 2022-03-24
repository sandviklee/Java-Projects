package selfcheckout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReceiptHandler implements IReceiptHandler {

    @Override
    public SelfCheckout readReceipt(String filename, SelfCheckout selfCheckout) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(getFile(filename))) {
            String phoneNumber = scanner.nextLine();
            if (!phoneNumber.equals("null")) {
                selfCheckout.registerPhoneNumber(phoneNumber);
            }
            while (scanner.hasNextLine()) {
                String[] properties = scanner.nextLine().split(";");
                selfCheckout.scanItem(new Item(properties[0], Double.parseDouble(properties[1]), properties[2]));
            }
        }
        return selfCheckout;
    }

    @Override
    public void writeReceipt(String filename, SelfCheckout selfCheckout) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(getFile(filename))) {
            writer.println(selfCheckout.getPhoneNumber());
            for (Item item : selfCheckout.getShoppingCartItems()) {
                writer.println(String.format("%s;%s;%s", item.getName(), item.getPrice(), item.getCategory()));
            }
        }

    }

    private static File getFile(String filename) {
        return new File("selfcheckout-example\\src\\main\\resources\\selfcheckoutmal3\\receipts\\" + filename + ".txt");
    }

}
