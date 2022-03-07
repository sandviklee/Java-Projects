package kortforklart.multiplefxmlfiles.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import kortforklart.multiplefxmlfiles.TextAreaService;

public class Tab1Controller {

	@FXML
	private TextArea textarea1;

	private TextAreaService service;

	public void initialize(TextAreaService service) {
		this.service = service;
	}

	@FXML
	public void setValue() {
		this.service.setTextAreaValue(textarea1.getText() + " Clicked on tab 1");
	}

	@FXML
	public void getValue() {
		this.textarea1.setText(this.service.getTextAreaValue());
	}

}
