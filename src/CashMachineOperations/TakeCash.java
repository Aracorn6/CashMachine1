package CashMachineOperations;

import BankInfo.*;
import CashMachineInfo.BanknoteInfo;
import CashMachineInfo.BanknoteLogic;


/**
 * Created by aracorn on 24.12.16.
 */
public class TakeCash {
    public void takeCash(BankCard card, int sum) {
        if (card.balance >= sum) {
            ConnectCardsInfo cardsInfo = new ConnectCardsInfo();
            int[] info = BanknoteInfo.readInfo();
            int[] result = BanknoteLogic.banknoteLogic(sum, info);
            card.balance -= result[5];
            System.out.println("Take " + result[5] + ". Banknotes: 5000 - " + result[6] + ", 1000 - " + result[7] + ", 500 - " + result[8] + ", 100 - " + result[9]);
            System.out.println("Your balance: " + card.balance);
            String writeToFile = result[0] + " " + result[1] + " " + result[2] + " " + result[3] + " " + result[4];
            BanknoteInfo.writeInfo(writeToFile);
            cardsInfo.changeCardsInfoDatabase(card.balance, card.number);
            Operations.transactionsMenu(card);
        } else {
            System.out.println("Error: your balance is too low");
            Operations.transactionsMenu(card);
        }
    }
}
