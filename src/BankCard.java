/**
 * Created by aracorn on 16.12.16.
 */
public class BankCard {
    int balance;
    int month;
    int year;
    long number;
    int pin;

    public BankCard(String firstName, String secondName, long number, int month, int year) {
        setMonth(month);
        setYear(year);
        setNumber(number);
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setNumber(long number) {
        this.number = number;
    }
}
