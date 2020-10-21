package Controller;
import Model.Assignment;
import View.SeeAssignment;
import Model.AssignmentDAO;

import java.util.ArrayList;

public class SeeAssignmentController {

    SeeAssignment seeAssignment = new SeeAssignment();
    AssignmentDAO assignmentDAO = new AssignmentDAO();

    public void allAssignment(int classID) {
        Assignment[] assignments = new Assignment[100];
        assignments = (Assignment[]) assignmentDAO.readAllAssignmentFromClass(classID);
        int answer = seeAssignment.allAssignment(assignments);
        //Enviar para a proxima tela assignments[answer].id;
    }
}
