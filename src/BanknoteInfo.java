import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by aracorn on 20.12.16.
 */
public class BanknoteInfo {
    public static int[] readInfo() {
        int[] intBanknoteInfo={};
        try {
            BufferedReader reader = new BufferedReader(new FileReader("BanknoteInfo.txt"));
            String[] splitBanknoteInfo = new String[5];
            splitBanknoteInfo = reader.readLine().split(" ");
            intBanknoteInfo = new int[splitBanknoteInfo.length];
            for (int i = 0; i < splitBanknoteInfo.length; i++) {
                intBanknoteInfo[i] = Integer.parseInt(splitBanknoteInfo[i]);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return intBanknoteInfo;
    }
    public static void writeInfo(String info) {
        try {
            FileWriter writer = new FileWriter("BanknoteInfo.txt");
            writer.write(info);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
