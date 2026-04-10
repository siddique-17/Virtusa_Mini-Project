import java.sql.*;

public class UserDAO {

    public static void addUser(String name, String email) {
        try {
            Connection con = DBConnection.getConnection();

            String q = "INSERT INTO users(name, email) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, name);
            ps.setString(2, email);

            ps.executeUpdate();

            System.out.println("✅ User Added!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void viewUsers() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("user_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}