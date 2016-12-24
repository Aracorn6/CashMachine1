package CashMachineOperations;

import BankInfo.ConnectPinInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import BankInfo.*;

/**
 * Created by aracorn on 16.12.16.
 */
public class CheckPin {
    public void checkPin(BankCard card) {
        try {
            ConnectPinInfo connectPin = new ConnectPinInfo();
            System.out.println("Enter a PIN (press R for return card)");
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            String readPin = rd.readLine();
            if (readPin.equalsIgnoreCase("R")) {
                Operations.returnCard();
                Operations.startMachine();
            }
            boolean report = connectPin.pinInfoDatabase(card.number, readPin);
            if (report) {
                System.out.println("PIN accepted.");
                Operations.transactionsMenu(card);
            } else {
                System.out.println("PIN decline.");
                Operations.operationCheckPinAgain(card);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
