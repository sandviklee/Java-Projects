package selfcheckout;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SelfCheckoutController {

    private SelfCheckout selfCheckout;
    private IReceiptHandler checkoutReceipt = new ReceiptHandler();
    private List<Item> selectableItemsList;

    @FXML
    public Button login, adminMode, deleteItem, backButton, checkout, scanReceipt;

    @FXML
    public TextArea checkoutText;

    @FXML
    public TextField phoneNumber;

    @FXML
    public GridPane itemGrid;

    @FXML
    public ListView<String> scannedItemsList;

    @FXML
    public void initialize() {
        initializeSelectableItemsList();
        selfCheckout = initializeSelfCheckout();
        updateCartDisplay();

        for (int i = 0; i < selectableItemsList.size(); i++) {
            Item selectableItem = selectableItemsList.get(i);
            itemGrid.add(createItemButton(selectableItem), i % 4, i / 4);
        }
    }

    @FXML
    public void handleLogin() {
        try {
            selfCheckout.registerPhoneNumber(phoneNumber.getText());
            updateCartDisplay();
            phoneNumber.disableProperty().set(true);
            login.disableProperty().set(true);
        } catch (IllegalArgumentException e) {
            showErrorMessage("Vennligst skriv inn et gyldig telefonnummer.");
        }
    }

    @FXML
    public void handleCheckout() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Write receipt");
        dialog.setHeaderText("Gi et navn til kvitteringen slik at du kan hente den frem igjen senere");
        dialog.setContentText("Navn:");

        // Dette er bare for å gi en fancy visning av kvitteringen:
        TextArea textArea = new TextArea(selfCheckout.toString());
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        textArea.setFont(Font.font("Courier New"));
        dialog.getDialogPane().setExpandableContent(textArea);
        dialog.getDialogPane().setExpanded(true);

        try {
            String receiptName = dialog.showAndWait().get();
            checkoutReceipt.writeReceipt(receiptName, selfCheckout);
            selfCheckout = initializeSelfCheckout();
            updateCartDisplay();
            phoneNumber.clear();
            phoneNumber.disableProperty().set(false);
            login.disableProperty().set(false);
        } catch (FileNotFoundException e) {
            showErrorMessage("Kvitteringen kunne ikke skrives til feil!");
        } catch (NoSuchElementException e) {
            // Do nothing
        }
    }

    @FXML
    public void handleAdminActivation() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Admin login");
        dialog.setHeaderText("Skriv inn admin-passord for denne enheten for å fortsette");
        dialog.setContentText("Passord:");
        dialog.setGraphic(new ImageView(this.getClass().getResource("lock_open.png").toString()));
        try {
            String password = dialog.showAndWait().get();
            selfCheckout.activateAdminMode(password);
            adminMode.visibleProperty().set(false);
            backButton.visibleProperty().set(true);
            deleteItem.visibleProperty().set(true);
            checkout.visibleProperty().set(false);
            scanReceipt.visibleProperty().set(true);
        } catch (IllegalArgumentException e) {
            // Recursive call to "ask" the user again
            showErrorMessage("Feil passord");
            handleAdminActivation();
        } catch (NoSuchElementException e) {
            // Do nothing if "Cancel"
        }
    }

    @FXML
    public void handleAdminDeactivation() {
        selfCheckout.deactivateAdminMode();
        adminMode.visibleProperty().set(true);
        backButton.visibleProperty().set(false);
        deleteItem.visibleProperty().set(false);
        checkout.visibleProperty().set(true);
        scanReceipt.visibleProperty().set(false);
    }

    @FXML
    public void handleScanReceipt() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Read receipt");
        dialog.setHeaderText("Skriv inn navn på kvitteringen du vil scanne inn");
        dialog.setContentText("Navn:");
        // Tar en midlertidig kopi av referansen til selfCheckout for å ikke miste den
        // hvis noe går galt
        SelfCheckout tempCheckout = selfCheckout;
        try {
            String receiptName = dialog.showAndWait().get();
            handleAdminDeactivation();
            selfCheckout = initializeSelfCheckout();
            checkoutReceipt.readReceipt(receiptName, selfCheckout);
            updateCartDisplay();
            updateCheckoutText();
            if (selfCheckout.getPhoneNumber() != null) {
                phoneNumber.setText(selfCheckout.getPhoneNumber());
                phoneNumber.disableProperty().set(true);
                login.disableProperty().set(true);
            }
        } catch (FileNotFoundException e) {
            showErrorMessage("Kvitteringen ble ikke funnet!");
            selfCheckout = tempCheckout;
        } catch (NoSuchElementException e) {
            // Do nothing
        }
    }

    @FXML
    public void handleItemDeletion() {
        int selectedIndex = scannedItemsList.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            selfCheckout.removeFromCart(selectedIndex);
            updateCartDisplay();
        } else {
            throw new IllegalArgumentException();
        }

    }

    private SelfCheckout initializeSelfCheckout() {
        String day = LocalDate.now().getDayOfWeek().name().substring(0, 3).toLowerCase();
        List<Campaign> discounts = List.of(
                new Campaign("Helgerabatt på taco", 0.3, "taco", true, List.of("fri", "sat")),
                new Campaign("Mandagsmat til under 200-lappen", 0.25, "dinner", false, List.of("mon")),
                new Campaign("Tilbuds-Torsdag", 0.1, null, true, List.of("thu")),
                new Campaign("Medlemsrabatt", 0.02, null, true,
                        List.of("mon", "tue", "wed", "thu", "fri", "sat", "sun"))

        );
        return new SelfCheckout(day, "test123", discounts);
    }

    private void showErrorMessage(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("En feil har oppstått");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    private Button createItemButton(Item item) {
        Button button = new Button(item.toString());
        button.wrapTextProperty().setValue(true);
        button.setStyle("-fx-text-alignment: center;");
        button.setCursor(Cursor.HAND);
        button.setOnAction((event) -> handleItemSelect(item));
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);

        return button;
    }

    private void handleItemSelect(Item item) {
        selfCheckout.scanItem(item);
        updateCartDisplay();
    }

    private void updateCartDisplay() {
        updateItemList();
        updateCheckoutText();
    }

    private void updateItemList() {
        scannedItemsList.getItems().setAll(selfCheckout.getCartDisplayList());
    }

    private void updateCheckoutText() {
        checkoutText.setText(selfCheckout.getCheckoutText());
    }

    private void initializeSelectableItemsList() {
        selectableItemsList = new ArrayList<>();
        selectableItemsList.addAll(List.of(
                new Item("Tomat", 5.0, "fruit"),
                new Item("Hvitost, Norvegia", 110.0, "diary"),
                new Item("Hvitost, Synnøve", 90.0, "diary"),
                new Item("Tortillalefser", 15.0, "taco"),
                new Item("Kjøttdeig, 400g", 29.99, "taco"),
                new Item("Egg, 6 stk", 41.59, "breakfast"),
                new Item("Leverpostei", 29.99, "breakfast"),
                new Item("Brød", 18.90, "breakfast"),
                new Item("Yoghurt", 15.50, "diary"),
                new Item("Fusilli", 25.0, "dinner"),
                new Item("Dolmio Classico", 40.0, "dinner"),
                new Item("Laksefilet, 500g", 107.0, "dinner"),
                new Item("Pose", 1.50, "general")));

    }

}
