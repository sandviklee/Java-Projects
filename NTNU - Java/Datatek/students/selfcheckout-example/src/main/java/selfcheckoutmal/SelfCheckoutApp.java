package selfcheckoutmal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SelfCheckoutApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Self-Checkout");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SelfCheckout.fxml"))));
        primaryStage.show();
    }

}
