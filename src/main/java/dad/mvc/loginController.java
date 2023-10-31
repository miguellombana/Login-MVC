package dad.mvc;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class loginController {

	private loginModel modelo = new loginModel();
	private loginVista vista = new loginVista();

	public loginController() {

		vista.getUsuario().textProperty().bindBidirectional(modelo.usuarioProperty());
		vista.getPass().textProperty().bindBidirectional(modelo.passProperty());
		vista.getLdap().selectedProperty().bindBidirectional(modelo.ldapProperty());

		vista.getAcceder().setOnAction(this::OnAccederAction);
		vista.getCancelar().setOnAction(this::OnCancelarAction);

	}

	private void OnAccederAction(ActionEvent e) {

		boolean useLdap = vista.getLdap().isSelected();

		AuthService auth = useLdap ? new LdapAuthService() : new FileAuthService();

		try {

			boolean login = auth.login(modelo.getUsuario(), modelo.getPass());
			if (login) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Iniciar sesion");
				alert.setHeaderText("Acceso permitido");
				alert.setContentText("Las credenciales de acceso son validas");

				alert.showAndWait();

			} else {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Iniciar sesion");
				alert.setHeaderText("Acceso denegado");
				alert.setContentText("Las credenciales de acceso son incorrectas");

				alert.showAndWait();

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private void OnCancelarAction(ActionEvent e) {

		Platform.exit();
	}

	public loginModel getModel() {

		return modelo;
	}

	public loginVista getVista() {

		return vista;
	}

}
