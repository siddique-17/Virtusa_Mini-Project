import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TransactionDAO {

    public static void issueBook(int bookId, int userId) {
        try {
            Connection con = DBConnection.getConnection();

            String q = "INSERT INTO transactions(book_id, user_id, issue_date) VALUES (?, ?, CURDATE())";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setInt(1, bookId);
            ps.setInt(2, userId);

            ps.executeUpdate();

            System.out.println("📚 Book Issued!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void returnBook(int transId) {
        try {
            Connection con = DBConnection.getConnection();

            String q = "SELECT issue_date FROM transactions WHERE trans_id=?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, transId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                LocalDate issueDate = rs.getDate("issue_date").toLocalDate();
                LocalDate returnDate = LocalDate.now();

                long days = ChronoUnit.DAYS.between(issueDate, returnDate);

                long fine = (days > 7) ? (days - 7) * 2 : 0;

                String update = "UPDATE transactions SET return_date=CURDATE() WHERE trans_id=?";
                PreparedStatement ps2 = con.prepareStatement(update);
                ps2.setInt(1, transId);
                ps2.executeUpdate();

                System.out.println("✅ Book Returned!");
                System.out.println("💰 Fine: ₹" + fine);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}