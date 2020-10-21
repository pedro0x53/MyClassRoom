package Controller;

import Model.ClassDAO;
import Model.UserDAO;
import View.Class;

import java.util.Random;

public class ClassController {
    Class cl = new Class();
    ClassDAO classDAO = new ClassDAO();
    int id;

    public ClassController(int id) {
        this.id = id;
    }

    public void createClass() {
        String nameClass = cl.createClass();
        String code = String.valueOf(generateCode(8));
        System.out.println("Turma de" + nameClass + "criada");
        System.out.println("Código da turma: " + code);

        classDAO.insertClass(code, nameClass, id);
    }

    public void enrollClass() {
        String code = cl.enrollClass();

        UserDAO userDAO = new UserDAO();
        int idClass = classDAO.searchClass(code);
        userDAO.updateUser("insert into enrollement (" + idClass + "," + code + ")");


    }

    private static char[] generateCode(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 3; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }

}
