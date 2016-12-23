import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aracorn on 17.12.16.
 */
public class Transactions {
    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    public void selectTransaction(BankCard card) throws IOException {
        CashMachine machine = new CashMachine();
        System.out.println("Select operation");
        System.out.println("GIVE(Give money) | TAKE(Take money) | RETURN(Return card)");
        String clientOperation = rd.readLine();
        if (clientOperation.equals("GIVE")) {
            machine.giveCash(card);
            Operations.transactionsMenu(card);
        }
        if (clientOperation.equals("TAKE")) {
            System.out.print("Summ: ");
            int sum=Integer.parseInt(rd.readLine());
            machine.takeCash(card, sum);
            Operations.transactionsMenu(card);
        }
        if (clientOperation.equals("RETURN")) {
            Operations.returnCard();
            Operations.startMachine();
        }
    }
}
