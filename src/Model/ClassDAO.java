package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ClassDAO {
    private Connection connection;

    public ClassDAO() {
        connection = new ConnectionDatabase().getConnection();
    }

    public Object[] readClass() {
        ArrayList<Class> classes = new ArrayList<Class>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from class");
            while(result.next()) {
                Class newClass = new Class();
                newClass.id = result.getInt("id");
                newClass.code = result.getString("code");
                newClass.name = result.getString("name");
                newClass.fk_user = result.getInt("fk_user");
                classes.add(newClass);
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
