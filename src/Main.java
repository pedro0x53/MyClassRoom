import Controller.AssignmentController;
import Controller.AuthenticationController;
import Utils.Menu;

public class Main {
    public static void main(String[] args) {
        AuthenticationController ac = new AuthenticationController();
        String[] items = {"Sair", "Login", "Cadastro"};
        int res = Menu.createMenu(items);
        if (res == 1) {
            ac.login();
        } else if (res == 2) {
            ac.signUp();
        }
    }
}
