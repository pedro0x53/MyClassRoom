package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClassDAO {
    private Connection connection;

    public ClassDAO() {
        connection = new ConnectionDatabase().getConnection();
    }

    public Object[] readClass() {
        ArrayList<Classes> classes = new ArrayList<Classes>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from class where fk_user = user.id");
            while(result.next()) {
                Classes newClasses = new Classes();
                newClasses.id = result.getInt("id");
                newClasses.code = result.getString("code");
                newClasses.name = result.getString("name");
                newClasses.fk_user = result.getInt("fk_user");
                classes.add(newClasses);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes.toArray();
    }

    public void insertClass(int id, String code, String name, int fk_user) {
        try {
            String query = "insert into user (id, code, name, fk_user) values (" + id +
                    ", '" + code + "', '" + name + "', '" + fk_user + "')";
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
