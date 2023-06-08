
import java.util.Scanner;

public class SwitcCaseYapisi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sayi giriniz... : ");
        int sayi = input.nextInt();
        switch (sayi) {
            case 1:
                System.out.println("Sayi 1");
                break;
            case 2:
                System.out.println("Sayi 2");
                break;
            case 3:
                System.out.println("Sayi 3");
                break;
            default:
                System.out.println("Sayi 1,2 veya 3 değil");
                break;
        }
    }
}
