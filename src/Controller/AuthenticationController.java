package Controller;

import View.Authentication;
import Model.UserDAO;
import Model.User;
import java.sql.SQLException;

public class AuthenticationController {
    Authentication auth = new Authentication();
    UserDAO user = new UserDAO();

    public User login() throws SQLException {
        String[] fields = auth.login();
        System.out.println("Email: " + fields[0] + "\tSenha: " + fields[1]);
        System.out.println("Login...");
        // Check on data base
        return user.getUser(fields[0], fields[1]);
    }

    public void signUp() {
        String[] fields = auth.signUp();
        System.out.println("Nome: " + fields[0] + "\tEmail: " + fields[1] + "\tSenha: " + fields[2]);
        System.out.println("Sign Up...");
        // Save on data base
        user.insertUser(fields[0], fields[1], fields[2]);
    }
}
