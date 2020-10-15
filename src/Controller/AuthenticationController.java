package Controller;

import View.Authentication;

public class AuthenticationController {
    Authentication auth = new Authentication();

    public void login() {
        String[] fields = auth.login();
        System.out.println("Email: " + fields[0] + "\nSenha: " + fields[1]);
        System.out.println("Login...");
        // Check on data base
    }

    public void signUp() {
        String[] fields = auth.signUp();
        System.out.println("Nome: " + fields[0] + "\nEmail: " + fields[1] + "\nSenha: " + fields[2]);
        System.out.println("Sign Up...");
        // Save on data base
    }
}
