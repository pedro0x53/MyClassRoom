package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class AssignmentDAO {
    private Connection connection;

    public AssignmentDAO() {
        connection =  ConnectionDatabase.getConnection();
    }

    public Object[] readAssignment() {
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from assignment where fk_class = class.id");
            while(result.next()) {
                Assignment newAssignment = new Assignment();
                newAssignment.id = result.getInt("id");
                newAssignment.title = result.getString("title");
                newAssignment.description = result.getString("description");
                newAssignment.startDate = result.getDate("startDate");
                newAssignment.endDate = result.getDate("endDate");
                newAssignment.fk_class = result.getInt("fk_class");
                assignments.add(newAssignment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assignments.toArray();
    }

    public void insertAssignment(int id, String title, String description, Date startDate, Date endDate, int fk_class) {
        try {
            String query = "insert into user (id, title, description, startDate, endDate, fk_class ) values (" + id +
                    ", '" + title + "', '" + description + "', '" + startDate +  "', '" + endDate +  "', '" + fk_class + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAssignment(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
