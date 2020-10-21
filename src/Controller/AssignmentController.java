package Controller;

import View.AssignmentView;

public class AssignmentController {
    AssignmentView assignment = new AssignmentView();
//    private Assignment model;

    public AssignmentController() {
//        this.model = AssignmentDAO.getAssignment(model.id);
    }

    public void view() {
        int action = assignment.view("Title", "Description", "01/01/2020", "31/12/2020");
        if (action == 0) {
            this.answer();
        }
    }

    public void answer() {
        String answer = assignment.answer();
        System.out.println("Resposta: " + answer);
        // Send to database
    }
}
