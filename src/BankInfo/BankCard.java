package BankInfo;

/**
 * Created by aracorn on 16.12.16.
 */
public class BankCard {
    public int balance;
    public int month;
    public int year;
    public String number;

    public BankCard(String firstName, String secondName, String number, int month, int year, int balance) {
        setMonth(month);
        setYear(year);
        setNumber(number);
        setBalance(balance);
    }

    private void setMonth(int month) {
        this.month = month;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    private void setBalance(int balance) {
        this.balance = balance;
    }
}
