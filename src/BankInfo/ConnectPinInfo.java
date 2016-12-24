package BankInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by aracorn on 23.12.16.
 */
public class ConnectPinInfo {

    public boolean pinInfoDatabase(String number, String pin) {
        boolean report = false;
        try {
            String url = "jdbc:postgresql://localhost:5432/bank";
            String login = "postgres";
            String password = "1111";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM cards.pins");
                while (rs.next()) {
                    if (number.equals(rs.getString(1)) && pin.equals(rs.getString(2))) {
                        report = true;
                    }
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
        return report;
    }
}

