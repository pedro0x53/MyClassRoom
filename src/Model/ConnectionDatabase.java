package Model;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionDatabase {
    private static String driver = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://localhost:5432/";
    private static String user = "";
    private static String password = "";
    private static Connection connection;
    private static ConnectionDatabase instance;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                //System.out.println("Conectado com sucesso");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
