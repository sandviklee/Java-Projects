package selfcheckoutmal;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class SelfCheckoutController {

    private SelfCheckout selfCheckout;

    @FXML
    public GridPane itemGrid;

    @FXML
    public ListView<Item> scannedItemsList;

    @FXML
    public void initialize() {

    }

}
