package View;

import Utils.FormFields;

public class NewAssignment {
    private final FormFields ff = new FormFields();

    public String[] createAssignment() {
        System.out.println("----- Nova Atividade -----");

        String[] assignment = new String[4];
        assignment[0] = ff.askForTextField("Título", "Título da Tarefa: ", true);
        assignment[1] = ff.askForTextField("Descrição", "Descrição da Tarefa: ", true);
        assignment[2] = ff.askForDate("Data de inicio", "Digite a data de inicio: ", false);
        assignment[3] = ff.askForDate("Data de Entrega", "Digite a data de entrega: ", false);

        return  assignment;
    }
}
