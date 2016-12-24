package CashMachineOperations;

import BankInfo.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by aracorn on 16.12.16.
 */
public class CashMachine {
    ConnectCardsInfo connect = new ConnectCardsInfo();
    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    public void start() {
        try {
            ArrayList<BankCard> cardsInfo = connect.cardsInfoDatabase();
            System.out.println("======================");
            System.out.println("Waiting.");
            System.out.println("INSERT CARD NUMBER");
            String number = rd.readLine();
            int count = 0;
            for (int i = 0; i < cardsInfo.size(); i++) {
                String cardNumber = cardsInfo.get(i).number;
                if (number.equals(cardNumber)) {
                    Operations.operationCheckCard(cardsInfo.get(i));
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("NO CARD WITH THIS NUMBER IN DATABASE.");
                Operations.returnCard();
                Operations.startMachine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
