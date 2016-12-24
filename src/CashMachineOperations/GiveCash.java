package CashMachineOperations;

import BankInfo.*;
import CashMachineInfo.BanknoteInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aracorn on 24.12.16.
 */
public class GiveCash {
    public void giveCash(BankCard card) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            ConnectCardsInfo cardsInfo = new ConnectCardsInfo();
            int[] info = BanknoteInfo.readInfo();
            int[] giveBanknotes = new int[4];
            System.out.print("Banknotes: 5000 - ");
            giveBanknotes[0] = Integer.parseInt(rd.readLine());
            System.out.print("1000 - ");
            giveBanknotes[1] = Integer.parseInt(rd.readLine());
            System.out.print("500 - ");
            giveBanknotes[2] = Integer.parseInt(rd.readLine());
            System.out.print("100 - ");
            giveBanknotes[3] = Integer.parseInt(rd.readLine());
            int sum = giveBanknotes[0] * 5000 + giveBanknotes[1] * 1000 + giveBanknotes[2] * 500 + giveBanknotes[3] * 100;
            card.balance += sum;
            System.out.println("Give " + sum);
            System.out.println("Your balance: " + card.balance);
            String writeToFile = (info[0] + sum) + " " + (info[1] + giveBanknotes[0]) + " " + (info[2] + giveBanknotes[1]) + " " + (info[3] + giveBanknotes[2]) + " " + (info[4] + giveBanknotes[3]);
            BanknoteInfo.writeInfo(writeToFile);
            cardsInfo.changeCardsInfoDatabase(card.balance, card.number);
            Operations.transactionsMenu(card);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
