import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by aracorn on 16.12.16.
 */
public class CashMachine {
    Bank bank = new Bank();
    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    public void start() throws IOException {
        ArrayList<BankCard> cardsInfo = bank.cardsData();
        System.out.println("======================");
        System.out.println("Waiting.");
        System.out.println("INSERT CARD NUMBER");
        long number = Long.parseLong(rd.readLine());
            int count=0;
            for (int i=0; i<cardsInfo.size(); i++) {
                long cardNumber = cardsInfo.get(i).number;
                if (number==cardNumber) {
                    Operations.operationCheckCard(cardsInfo.get(i));
                    count++;
                }
            }
            if (count==0) {
                System.out.println("NO CARD WITH THIS NUMBER IN DATABASE.");
                Operations.returnCard();
                Operations.startMachine();
            }
    }


    public void giveCash(BankCard card) throws IOException {
        int[] info = BanknoteInfo.readInfo();
        int[] giveBanknotes = new int [4];
        System.out.print("Banknotes: 5000 - ");
        giveBanknotes[0] = Integer.parseInt(rd.readLine());
        System.out.print("1000 - ");
        giveBanknotes[1] = Integer.parseInt(rd.readLine());
        System.out.print("500 - ");
        giveBanknotes[2] = Integer.parseInt(rd.readLine());
        System.out.print("100 - ");
        giveBanknotes[3] = Integer.parseInt(rd.readLine());
        int sum = giveBanknotes[0]*5000+giveBanknotes[1]*1000+giveBanknotes[2]*500+giveBanknotes[3]*100;
        card.balance+=sum;
        System.out.println("Give " + sum);
        System.out.println("Your balance: " + card.balance);
        String writeToFile = (info[0]+sum) + " " + (info[1]+giveBanknotes[0]) + " " + (info[2]+giveBanknotes[1]) + " " + (info[3]+giveBanknotes[2]) + " " + (info[4]+giveBanknotes[3]);
        BanknoteInfo.writeInfo(writeToFile);
        Operations.transactionsMenu(card);
    }
    public void takeCash(BankCard card, int sum) throws IOException{
        if (card.balance>=sum) {
            int[] info = BanknoteInfo.readInfo();
            int[] result = BanknoteLogic.logic(sum, info);
            card.balance-=result[5];
            System.out.println("Take " + result[5] +". Banknotes: 5000 - " + result[6] + ", 1000 - " + result[7] + ", 500 - " + result[8] + ", 100 - " + result[9]);
            System.out.println("Your balance: " + card.balance);
            String writeToFile = result[0] + " " + result[1] + " " + result[2] + " " + result[3] + " " + result[4];
            BanknoteInfo.writeInfo(writeToFile);
            Operations.transactionsMenu(card);
        } else {
            System.out.println("Error: your balance is too low");
            Operations.transactionsMenu(card);
        }
    }
}
