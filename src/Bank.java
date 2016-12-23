import java.util.ArrayList;
import java.net.*;

/**
 * Created by aracorn on 17.12.16.
 */
public class Bank {
    public ArrayList<BankCard> cardsData() {
        BankCard card = new BankCard("Anton", "Volkov", 6666444433332222L, 9, 2018);
        BankCard card1 = new BankCard("Anton", "Volkov", 5555444433332222L, 9, 2014);
        BankCard card2 = new BankCard("Anton", "Volkov", 7777444433332222L, 9, 2018);
        card.pin=6666;
        card1.pin=5555;
        card2.pin=7777;
        card.balance=8000;
        card1.balance=10000;
        card2.balance=0;
        ArrayList<BankCard> cards = new ArrayList<>();
        cards.add(card);
        cards.add(card1);
        cards.add(card2);
        return cards;
    }
}
