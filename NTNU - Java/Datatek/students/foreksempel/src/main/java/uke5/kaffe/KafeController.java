package uke5.kaffe;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class KafeController {

	MiniKafe mk = new MiniKafe();
	Person p = new Person("Jo");
	
	@FXML Text output;

	@FXML
	void handleNew() {
		p = new Person("Even");
		output.setText("Har "+p.getNavn()+" fått nok kaffe: "+p.nokKaffe());
//		updateOutput();
	}

	void updateOutput() {
		String outputString = "Ferdig? ";
		if (p.nokKaffe()) {
			outputString += " Ja!";
		} else {
			outputString += " Nei";			
		}
		output.setText(outputString);
	}
	
	@FXML
	void handleServer() {
		p.drikkKaffe();
		updateOutput();
	}
}
