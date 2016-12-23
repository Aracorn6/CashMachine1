/**
 * Created by aracorn on 16.12.16.
 */
public class BankCard {
    int balance;
    int month;
    int year;
    String number;

    public BankCard(String firstName, String secondName, String number, int month, int year, int balance) {
        setMonth(month);
        setYear(year);
        setNumber(number);
        setBalance(balance);
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setBalance(int balance) {this.balance = balance; }
}
