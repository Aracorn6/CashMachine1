import java.sql.*;
import java.util.ArrayList;

/**
 * Created by aracorn on 16.12.16.
 */
public class ConnectCardsInfo {

    public ArrayList<BankCard> cardsInfoDatabase() {
        ArrayList<BankCard> cards = new ArrayList<>();
        try {
            String url = "jdbc:postgresql://localhost:5432/bank";
            String login = "postgres";
            String password = "SqrtBtaq359937";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM cards.cards");
                while (rs.next()) {
                    BankCard card = new BankCard(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                    cards.add(card);
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
        return cards;
    }

    public void changeCardsInfoDatabase(int balance, String number) {
        try {
            String url = "jdbc:postgresql://localhost:5432/bank";
            String login = "postgres";
            String password = "SqrtBtaq359937";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                PreparedStatement ps = con.prepareStatement("UPDATE cards.cards SET balance =" + balance + " WHERE number ='" + number+"'");
                ps.executeUpdate();
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