package kortforklart.multiplefxmlfiles.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import kortforklart.multiplefxmlfiles.TextAreaService;

public class MainController {

    @FXML
    private Tab1Controller tab1Controller;
    @FXML
    private Tab2Controller tab2Controller;

    private TextAreaService service;

    @FXML
    public void initialize() {
        service = new TextAreaService();
        tab1Controller.initialize(service);
        tab2Controller.initialize(service);
    }

}
