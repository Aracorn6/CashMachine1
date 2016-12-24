package CashMachineOperations;

import BankInfo.*;

/**
 * Created by aracorn on 24.12.16.
 */
public class CheckBalance {
    public void checkBalance(BankCard card) {
        System.out.println("Your balance: " + card.balance);
        Operations.transactionsMenu(card);
    }
}
