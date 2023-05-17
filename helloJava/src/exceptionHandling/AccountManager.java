package exceptionHandling;
// bu dosya throwDemo da kullanıldı

public class AccountManager {

    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withDraw(double amount) throws BalanceInSufficientException { // kullanan kişinin try-catch icine almasi icin eklendi
        if (balance >= amount) {
            balance = getBalance() - amount;

        } else {
            throw new BalanceInSufficientException("Bakiye yetersiz"); // custom exception
        }

    }

    public double getBalance() {
        return balance;
    }

}
