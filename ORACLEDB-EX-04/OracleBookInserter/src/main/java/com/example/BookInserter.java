import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class BookInserter {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//34.58.243.236/XE";
        String username = "sys as sysdba";
        String password = "ORACLE";

        String insertSQL = "INSERT INTO BOOK (ID, NAME, ISBN) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

            Random random = new Random();

            for (int i = 1; i <= 100; i++) {
                stmt.setInt(1, i);
                stmt.setString(2, "Book " + i);
                stmt.setString(3, "ISBN" + (100000 + random.nextInt(900000)));
                stmt.executeUpdate();
            }

            System.out.println("100 kitap başarıyla eklendi.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
