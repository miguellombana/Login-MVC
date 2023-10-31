package dad.mvc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class loginVista extends VBox {

	private TextField usuario;
	private PasswordField pass;
	private CheckBox ldap;
	private Button acceder;
	private Button cancelar;

	public loginVista() {
		super();

		HBox h1 = new HBox();
		HBox h2 = new HBox();
		HBox h3 = new HBox();
		Label l1 = new Label("Usuario: ");
		Label l2 = new Label("Contraseña: ");

		usuario = new TextField();
		pass = new PasswordField();
		ldap = new CheckBox("Usar LDAP");
		acceder = new Button("Acceder");
		cancelar = new Button("Cancelar");

		usuario.setPromptText("Nombre del usuario");
		pass.setPromptText("Contraseña");

		h1.setAlignment(Pos.CENTER);
		h2.setAlignment(Pos.CENTER);
		h3.setAlignment(Pos.CENTER);
		h1.setSpacing(5);
		h2.setSpacing(5);
		h3.setSpacing(5);

		h1.setPadding(new Insets(5));
		h2.setPadding(new Insets(5));
		h3.setPadding(new Insets(5));

		h1.getChildren().addAll(l1, usuario);
		h2.getChildren().addAll(l2, pass);
		h3.getChildren().addAll(acceder, cancelar);

		getChildren().addAll(h1, h2, ldap, h3);
		setAlignment(Pos.CENTER);
		setSpacing(5);

	}

	public TextField getUsuario() {
		return usuario;
	}

	public PasswordField getPass() {
		return pass;
	}

	public CheckBox getLdap() {
		return ldap;
	}

	public Button getAcceder() {
		return acceder;
	}

	public Button getCancelar() {
		return cancelar;
	}

}
