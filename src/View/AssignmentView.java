package View;

import Utils.FormFields;
import Utils.Menu;

public class AssignmentView {
    private final FormFields ff = new FormFields();

    public int view(String title, String desc, String startDate, String endDte) {
        System.out.println("----- Atividade: " + title + " -----");
        System.out.println(startDate + " - " + endDte );
        System.out.println(desc);

        String[] options = {"Responder", "Voltar"};
        return Menu.createMenu(options);
    }

    public String answer() {
        System.out.println("ENUNCIADO\n");
        return ff.askForTextField("Resposta", "Digite sua resposta: ", false);
    }
}
