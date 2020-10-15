import Controller.AuthenticationController;
import Utils.Menu;

public class Main {
    public static void main(String[] args) {
        AuthenticationController ac = new AuthenticationController();
        String[] items = {"Login", "Cadastro"};
        int res = Menu.createMenu(items);
        if (res == 0) {
            ac.login();
        } else if (res == 1) {
            ac.signUp();
        }
    }
}
