package View;

import Controller.SeeAssignmentController;
import Model.Classes;
import Utils.FormFields;
import Utils.Menu;

public class Class {
    private FormFields ff = new FormFields();

    public String createClass() {
        String nameClass;
        System.out.println("----- Criar Turma -----");
        nameClass = ff.askForTextField("nome da turma", "Nome da turma: ", true);
        return nameClass;
    }

    public String enrollClass() {
        String code;
        System.out.println("----- Participar da turma -----");
        code = ff.askForTextField("código", "Código da turma: ", true);
        return code;
    }

    public void showClasses( Classes[] classes ) {
        System.out.println("----- Turmas -----");
        String[] messages = new String[100];

        SeeAssignmentController seeAssignmentController = new SeeAssignmentController();

        for (int i = 0; i < classes.length; i++) {
            String message = "" + classes[i].name + "";
            messages[i] = message;
        }

        int answer = Menu.createMenu(messages);

        seeAssignmentController.allAssignment(answer);
    }

}
