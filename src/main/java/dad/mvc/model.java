package dad.mvc;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class model {

	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty pass = new SimpleStringProperty();
	private BooleanProperty ldap = new SimpleBooleanProperty();
	public final StringProperty usuarioProperty() {
		return this.usuario;
	}
	
	public final String getUsuario() {
		return this.usuarioProperty().get();
	}
	
	public final void setUsuario(final String usuario) {
		this.usuarioProperty().set(usuario);
	}
	
	public final StringProperty passProperty() {
		return this.pass;
	}
	
	public final String getPass() {
		return this.passProperty().get();
	}
	
	public final void setPass(final String pass) {
		this.passProperty().set(pass);
	}
	
	public final BooleanProperty ldapProperty() {
		return this.ldap;
	}
	
	public final boolean isLdap() {
		return this.ldapProperty().get();
	}
	
	public final void setLdap(final boolean ldap) {
		this.ldapProperty().set(ldap);
	}

	
}




