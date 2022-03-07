package kortforklart.multiplefxmlfiles.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import kortforklart.multiplefxmlfiles.TextAreaService;

public class Tab2Controller {

  @FXML
  private TextArea textArea2;

  private TextAreaService service;

  public void initialize(TextAreaService service) {
    this.service = service;
  }

  @FXML
  public void setValue() {
    this.service.setTextAreaValue(textArea2.getText() + " Clicked on tab 2");
  }

  @FXML
  public void getValue() {
    this.textArea2.setText(this.service.getTextAreaValue());
  }

}
