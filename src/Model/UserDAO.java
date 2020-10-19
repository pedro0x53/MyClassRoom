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
    public User[] readUser() {
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
        return (User[]) users.toArray();
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

    public Classes[] getMyClasses(int userId) {
        ArrayList<Classes> classes = new ArrayList<Classes>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from class where id in (select fk_class from enrollment where " +
                    + userId + "= fk_id)");
            while(result.next()) {
                Classes newClass = new Classes();
                newClass.id = result.getInt("id");
                newClass.code = result.getString("code");
                newClass.name = result.getString("name");
                newClass.fk_user = result.getInt("fk_user");
                classes.add(newClass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Classes[]) classes.toArray();
    }

    public Assignment[] getMyClasses(int userId) {
        ArrayList<Assignment> assignment = new ArrayList<Assignment>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from assignment where fk_class = class.id and id in (select fk_assignment from submission where fk_user =  " +
                    + userId + "and state = 0)");
            while(result.next()) {
                Assignment newAssignment = new Assignment();
                newAssignment.id = result.getInt("id");
                newAssignment.title = result.getString("title");
                newAssignment.description = result.getString("description");
                newAssignment.startDate = result.getDate("startDate");
                newAssignment.endDate = result.getDate("endDate");
                newAssignment.fk_class = result.getInt("fk_class");
                assignment.add(newAssignment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Assignment []) assignment.toArray();
    }

}
