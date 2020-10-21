import Controller.AuthenticationController;
import Utils.Menu;
import  Model.User;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AuthenticationController ac = new AuthenticationController();

        // Menu - login
        String[] items = {"Sair", "Login", "Cadastro"};
        int res = Menu.createMenu(items);

        if (res == 1) {
            User user = new User();
            user = ac.login();

            // Menu - inicial
            String[] initial = {"Criar turma", "Participar de uma turma", "Visualizar turmas"};
            int resInitial = Menu.createMenu(initial);

            switch(resInitial) {
                case 0:
                    // Brena
                    System.out.println("Criar uma turma");
                    break;
                case 1:
                    // Brena
                    System.out.println("Participar de uma turma");
                    break;
                case 2:
                    // Brena
                    System.out.println("Visualizar turmas");
                    break;
            }
        } else if (res == 2) {
            ac.signUp();
        }
    }
}
