package kortforklart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application{
	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("My app");
		FXMLLoader fxml = (FXMLLoader.load(App.class.getResource("Ui.fxml")));
		AppController controller = (AppController) fxml.getController();
		primaryStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("Ui.fxml"))));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		App.launch(args);
	}

}
