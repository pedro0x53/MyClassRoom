package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SubmissionDAO {
    private Connection connection;

    public SubmissionDAO() {
        connection = new ConnectionDatabase().getConnection();
    }

    public void insertSubmission(int id, String answer, Boolean state, int fk_user, int fk_assignment) {
        try {
            String query = "insert into user (id, answer, state, fk_user, fk_assignment) values (" + id +
                    ", '" + answer + "', '" + state + "', '" + fk_user +  "', '" + fk_assignment + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSubmission(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
