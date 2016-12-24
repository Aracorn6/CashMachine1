package CashMachineOperations;

import BankInfo.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aracorn on 17.12.16.
 */
public class Transactions {
    public void selectTransaction(BankCard card) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.println("======================");
            System.out.println("Select operation");
            System.out.println("GIVE(Give money) | TAKE(Take money) | CHECK(Check balance) | RETURN(Return card)");
            String clientOperation = rd.readLine();
            if (clientOperation.equalsIgnoreCase("GIVE")) {
                Operations.giveCash(card);
                Operations.transactionsMenu(card);
            }
            if (clientOperation.equalsIgnoreCase("TAKE")) {
                System.out.print("Summ: ");
                int sum = Integer.parseInt(rd.readLine());
                Operations.takeCash(card, sum);
                Operations.transactionsMenu(card);
            }
            if (clientOperation.equalsIgnoreCase("CHECK")) {
                Operations.checkBalance(card);
            }
            if (clientOperation.equalsIgnoreCase("RETURN")) {
                Operations.returnCard();
                Operations.startMachine();
            } else {
                System.out.println("Error. Card returned.");
                Operations.returnCard();
                Operations.startMachine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
