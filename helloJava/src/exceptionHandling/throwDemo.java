package exceptionHandling;

public class throwDemo {

    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        System.out.println("Hesap : " + manager.getBalance());
        manager.deposit(100);
        System.out.println("Hesap : " + manager.getBalance());
        try {
            manager.withDraw(90);
        } catch (BalanceInSufficientException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Hesap : " + manager.getBalance());
        try {
            manager.withDraw(20);
        } catch (BalanceInSufficientException e) {
            System.out.println(e.getMessage()); // fırlattığımız mesajı yakaladık
        }

        System.out.println("Hesap : " + manager.getBalance());
    }
}
