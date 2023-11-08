package dad.login;

import dad.login.mvc.loginControllerFXML;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private loginControllerFXML control = new loginControllerFXML();

	@Override

	public void start(Stage primaryStage) throws Exception {

		Scene scene = new Scene(control.getVista(), 320, 200);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Login modelo vista controlador");
		primaryStage.show();

	}
}
