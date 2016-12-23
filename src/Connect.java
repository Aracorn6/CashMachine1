import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by aracorn on 16.12.16.
 */
public class Connect {

    private void testDatabase() {
        try {
            String url = "jdbc:postgresql://localhost:5432/bank";
            String login = "postgres";
            String password = "SqrtBtaq359937";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM cards.cards");
                while (rs.next()) {
                    BankCard card = new BankCard(rs.getString(1), rs.getString(2), rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6), rs.getString(7), rs.getString(8));
                }
                rs.close();
                stmt.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}