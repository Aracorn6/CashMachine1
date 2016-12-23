
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;

/**
 * Created by aracorn on 19.12.16.
 */
public class Operations {
    static CashMachine machine;
    static CheckPin checkPin;
    static CheckCard checkCard;
    static TryAgain checkPinAgain;
    static Transactions transactions;

    public static void startMachine() throws IOException {
        machine = new CashMachine();
        machine.start();
    }
    public static void operationCheckPin(BankCard card) throws IOException{
        checkPin = new CheckPin();
        checkPin.checkPin(card);
    }
    public static void operationCheckPinAgain(BankCard card) throws IOException{
        checkPinAgain = new TryAgain();
        checkPinAgain.askTryAgain(card);
    }
    public static void operationCheckCard(BankCard card) throws IOException{
        checkCard = new CheckCard();
        checkCard.checkCard(card);
    }
    public static void transactionsMenu(BankCard card) throws IOException{
        System.out.println("======================");
        transactions = new Transactions();
        transactions.selectTransaction(card);
    }
    public static void returnCard() {
        System.out.println("Card returned.");
        machine = null;
        checkPin = null;
        checkPinAgain = null;
        checkCard = null;
        transactions = null;
    }
}
