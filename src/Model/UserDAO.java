package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {

    private Connection connection;

    public UserDAO() {
        connection = new ConnectionDatabase().getConnection();
    }

    //Retornar um array de users
    public Object[] readUser() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from user");
            while(result.next()) {
                User newUser = new User();
                newUser.id = result.getInt("id");
                newUser.name = result.getString("name");
                newUser.email = result.getString("email");
                newUser.password = result.getString("password");
                users.add(newUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users.toArray();
    }

    public void insertUser(int id, String name, String email, String password) {
        try {
            String query = "insert into user (id, name, email, password) values (" + id +
                    ", '" + name + "', '" + email + "', '" + password + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
