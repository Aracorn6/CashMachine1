package CashMachineOperations;

import BankInfo.*;

/**
 * Created by aracorn on 19.12.16.
 */
public class Operations {
    private static CashMachine machine;
    private static CheckPin checkPin;
    private static CheckCard checkCard;
    private static TryAgain checkPinAgain;
    private static Transactions transactions;
    private static GiveCash give;
    private static TakeCash take;
    private static CheckBalance check;

    public static void startMachine() {
        machine = new CashMachine();
        machine.start();
    }

    public static void operationCheckPin(BankCard card) {
        checkPin = new CheckPin();
        checkPin.checkPin(card);
    }

    public static void operationCheckPinAgain(BankCard card) {
        checkPinAgain = new TryAgain();
        checkPinAgain.askTryAgain(card);
    }

    public static void operationCheckCard(BankCard card) {
        checkCard = new CheckCard();
        checkCard.checkCard(card);
    }

    public static void transactionsMenu(BankCard card) {
        transactions = new Transactions();
        transactions.selectTransaction(card);
    }

    public static void giveCash(BankCard card) {
        give = new GiveCash();
        give.giveCash(card);
    }

    public static void takeCash(BankCard card, int sum) {
        take = new TakeCash();
        take.takeCash(card, sum);
    }

    public static void checkBalance(BankCard card) {
        check = new CheckBalance();
        check.checkBalance(card);
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
