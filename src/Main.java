import Controller.AuthenticationController;
import Controller.ClassController;
import Model.ClassDAO;
import Model.Classes;
import Utils.Menu;
import  Model.User;
import View.Class;

import java.sql.SQLException;

public class Main {
    private static Object Classes;

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

            ClassController cc = new ClassController(user.id);
            Class cv = new Class();

            switch(resInitial) {
                case 0:
                    cc.createClass();
                    break;
                case 1:
                    cc.enrollClass();
                    break;
                case 2:
                    ClassDAO classdao = new ClassDAO();
                    Classes[] classes = new Classes[100];
                    classes = (Classes[]) classdao.readAllClasseOwned(user.id);
                    cv.showClasses(classes);
                    break;
            }
        } else if (res == 2) {
            ac.signUp();
        }
    }
}
