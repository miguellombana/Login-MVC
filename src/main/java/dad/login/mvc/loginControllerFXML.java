package dad.login.mvc;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class loginControllerFXML implements Initializable {

	// model
	
	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty pass = new SimpleStringProperty();
	private BooleanProperty ldap = new SimpleBooleanProperty();

	// vista
	
    @FXML
    private CheckBox ldapCheckbox;

    @FXML
    private PasswordField passInput;

    @FXML
    private TextField usuarioInput;

    @FXML
    private VBox view;
	
    public loginControllerFXML() {
    	
    	
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/loginVista.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // bindings

    	
    	
    	usuario.bind(usuarioInput.textProperty());
    	pass.bind(passInput.textProperty());
    	ldap.bind(ldapCheckbox.selectedProperty());
    	
    	
    	/*
    	vista.getUsuario().textProperty().bindBidirectional(modelo.usuarioProperty());
		vista.getPass().textProperty().bindBidirectional(modelo.passProperty());
		vista.getLdap().selectedProperty().bindBidirectional(modelo.ldapProperty()); */
    	
    }
    
    
    public VBox getVista() {
		return view;
	}

    @FXML
    private void OnAccederAction(ActionEvent e) {
        boolean useLdap = ldap.get();

        AuthService auth = useLdap ? new LdapAuthService() : new FileAuthService();

        try {
            boolean login = auth.login(usuario.get(), pass.get());
            if (login) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Iniciar sesión");
                alert.setHeaderText("Acceso permitido");
                alert.setContentText("Las credenciales de acceso son válidas");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Iniciar sesión");
                alert.setHeaderText("Acceso denegado");
                alert.setContentText("Las credenciales de acceso son incorrectas");
                alert.showAndWait();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    private void OnCancelarAction(ActionEvent e) {
        javafx.application.Platform.exit();
    }
}