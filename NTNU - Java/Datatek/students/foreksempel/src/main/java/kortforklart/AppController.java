package kortforklart;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AppController {
	
	@FXML private TextField brukernavn, passord;
	@FXML private TextArea output;
	
	@FXML
	public void onLogIn() {
		String brukernavn = this.brukernavn.getText();
		String passord = this.passord.getText();
		
		if (brukernavn.equals("admin") && passord.equals("admin")) {
			output.setText("Gratulerer du har logget inn!");
		}
		else {
			output.setText("Feil brukernavn eller passord");
		}
	}
	
}
