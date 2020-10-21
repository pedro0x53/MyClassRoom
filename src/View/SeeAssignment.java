package View;
import Model.Assignment;
import Utils.FormFields;
import Utils.Menu;

public class SeeAssignment {
    private FormFields ff = new FormFields();

    public int allAssignment(Assignment[] assignments) {
        System.out.println("----- Todas as atividades -----");
        String[] messages = new String[100];
        for (int i = 0; i < assignments.length; i++) {
            String message = "" + assignments[i].title + "\nInício:" + assignments[i].startDate + "\tPrazo final:" + assignments[i].endDate + "";
            messages[i] = message;
        }
        int asnwer = Menu.createMenu(messages);
        return asnwer;
    }
}
