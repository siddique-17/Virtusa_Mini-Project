import java.sql.*;

public class BookDAO {

    public static void addBook(String title, String author, int quantity) {
        try {
            Connection con = DBConnection.getConnection();

            String q = "INSERT INTO books(title, author, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, quantity);

            ps.executeUpdate();
            System.out.println("✅ Book Added!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void viewBooks() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("book_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | Qty: " +
                        rs.getInt("quantity"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void searchBook(String key) {
        try {
            Connection con = DBConnection.getConnection();

            String q = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("book_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteBook(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String q = "DELETE FROM books WHERE book_id=?";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("🗑️ Book Deleted!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}