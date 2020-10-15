package Model;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionDatabase {
    private static String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5432/";
    private String user;
    private String password;
    private Connection connection;

    public ConnectionDatabase(String databaseName, String user, String password ) {
        this.url += databaseName;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            //System.out.println("Conectado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
