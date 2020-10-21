package Controller;

import View.NewAssignment;

public class NewAssignmentController {
    private NewAssignment newAssignment = new NewAssignment();

    public void createAssignment(int classID) {
        String[] assignment = newAssignment.createAssignment();
        System.out.println("Título: " + assignment[0]);
        System.out.println("Data de Inicio: " + assignment[2] + "\tData de Entrega: " + assignment[2]);
        System.out.println("Desscrição: " + assignment[1]);
        // Send to database
    }
}
