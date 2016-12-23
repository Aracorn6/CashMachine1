import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by aracorn on 16.12.16.
 */
public class CheckPin {
    public void checkPin(BankCard card) throws IOException {
        System.out.println("Enter a PIN (press R for return card)");
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String readPin = rd.readLine();
        if (readPin.equals("R")) {
            Operations.returnCard();
            Operations.startMachine();
        } else if (Integer.parseInt(readPin)==card.pin) {
            System.out.println("PIN accepted.");
            Operations.transactionsMenu(card);
        } else {
            System.out.println("PIN decline.");
            Operations.operationCheckPinAgain(card);
        }
    }
}
