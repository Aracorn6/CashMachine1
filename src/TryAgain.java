import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aracorn on 16.12.16.
 */
public class TryAgain extends CheckPin{
    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    public void askTryAgain(BankCard card) throws IOException {
        System.out.println("Try again? (y/n)");
        String answer=rd.readLine();
        if (answer.equals("yes")||answer.equals("y")) {
            super.checkPin(card);
        } else if(answer.equals("no")||answer.equals("n")) {
            System.out.println("Exit.");
            Operations.returnCard();
            Operations.startMachine();

        } else {
            System.out.println("Error.");
            Operations.returnCard();
            Operations.startMachine();
        }
    }
}
