package dad.login;

import dad.mvc.loginController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private loginController control = new loginController();

	@Override

	public void start(Stage primaryStage) throws Exception {

		Scene scene = new Scene(control.getVista(), 320, 200);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Login modelo vista controlador");
		primaryStage.show();

	}
}
