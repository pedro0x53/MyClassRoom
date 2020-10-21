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
    public User[] readAllStudentsFromClass(int classId) {
        ArrayList<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from user where id in (select fk_user from enrollment where fk_class = " + classId + "");
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
        return (User[]) users.toArray();
    }

    public void insertUser(String name, String email, String password) {
        try {
            String query = "insert into user (name, email, password) values (" + name + "', '" + email + "', '" + password + "')";
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

    //Pegar so um usuario, retorna o user ( recebo, login e senha)
    public User getUser (String email, String password) throws SQLException {
        User user = new User();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from User" +
                    "where (User.email = "+ email + " and User.password = " + password + ")");
            user.id = result.getInt("id");
            user.name = result.getString("name");
            user.email = result.getString("email");
            user.password = result.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
