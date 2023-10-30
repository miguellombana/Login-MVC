package dad.mvc;

import dad.login.auth.AuthService;

public class controller {

	
	 private AuthService authService;

	    public controller(AuthService authService) {
	        this.authService = authService;
	    }

	    public boolean login(String username, String password) {
	        try {
	            return authService.login(username, password);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}
