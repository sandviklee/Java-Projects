package selfcheckout;

import java.io.FileNotFoundException;

public interface IReceiptHandler {

    SelfCheckout readReceipt(String filename, SelfCheckout selfCheckout) throws FileNotFoundException;

    void writeReceipt(String filename, SelfCheckout selfCheckout) throws FileNotFoundException;

}
