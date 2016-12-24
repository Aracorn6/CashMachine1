package CashMachineOperations;

import BankInfo.*;

import java.util.Calendar;

/**
 * Created by aracorn on 19.12.16.
 */
public class CheckCard {
    public void checkCard(BankCard card) {
        Calendar c = Calendar.getInstance();
        int yearRightNow = c.get(c.YEAR);
        int monthRightNow = c.get(c.MONTH);
        if (yearRightNow > card.year) {
            System.out.println("Card is expired.");
            Operations.returnCard();
            Operations.startMachine();
        } else if (yearRightNow == card.year && monthRightNow >= card.month) {
            System.out.println("Card is expired.");
            Operations.returnCard();
            Operations.startMachine();
        } else {
            Operations.operationCheckPin(card);
        }
    }
}
