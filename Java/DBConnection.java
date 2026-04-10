import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static final String URL = "jdbc:mysql://localhost:3306/library";
    static final String USER = "root";
    static final String PASS = "Sid@2004";

   public static Connection getConnection() {
    try {
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        System.out.println("✅ Connected to DB");
        return con;
    } catch (Exception e) {
        System.out.println("❌ DB ERROR: " + e);
        return null;
    }
}
}