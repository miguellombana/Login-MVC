package dad.mvc;









import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class vista  extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		VBox v1= new VBox();
		HBox h1= new HBox();
		HBox h2= new HBox();
		HBox h3= new HBox();
		TextField t1 = new TextField();
		PasswordField pass = new PasswordField();
		CheckBox c1 = new CheckBox("usar LDAP");
		Button b1 = new Button("Acceder");
		Button b2 = new Button("Cancelar");
		
		t1.setPromptText("Contraseña del usuario");
		pass.setPromptText("Contraseña");
		
		
		v1.setAlignment(Pos.CENTER);
		h1.getChildren().addAll(new Label("Usuario: "),t1);
		h2.getChildren().addAll(new Label("Contraseña: "),pass);
		h3.getChildren().addAll(b1,b2);
		
		h1.setAlignment(Pos.CENTER);
		h2.setAlignment(Pos.CENTER);
		h3.setAlignment(Pos.CENTER);
		
		
		v1.getChildren().addAll(h1,h2, c1 ,h3);
		
        Scene scene = new Scene(v1, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(true);
        
	}

}
