package uke5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CarApp extends Application{
	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("Car");
		primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("CarGUI.fxml"))));
		primaryStage.show();
	}
	
	public static void main(final String[] args) {
		Application.launch(args);
	}
}
