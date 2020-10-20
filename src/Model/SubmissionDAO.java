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

    public Object[] readSubmission(int userId) {
        ArrayList<Submission> submissions = new ArrayList<Submission>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select fk_assignment from submission where fk_user = " + userId + "and state = 0");
            while(result.next()) {
                Submission newSubmission = new Submission();
                newSubmission.id = result.getInt("id");
                newSubmission.answer = result.getString("answer");
                newSubmission.state = result.getBoolean("state");
                newSubmission.fk_user = result.getInt("fk_user");
                newSubmission.fk_assignment = result.getInt("fk_assignment");
                submissions.add(newSubmission);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return submissions.toArray();
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
