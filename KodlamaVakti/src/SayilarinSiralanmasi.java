
import java.util.Scanner;

public class SayilarinSiralanmasi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sayi1, sayi2, sayi3;
        System.out.print("Sayi1 : ");
        sayi1 = scanner.nextInt();
        System.out.print("Sayi2 : ");
        sayi2 = scanner.nextInt();
        System.out.print("Sayi3 : ");
        sayi3 = scanner.nextInt();
        if (sayi1 != sayi2 && sayi2 != sayi3) {
            if (sayi1 > sayi2 && sayi1 > sayi3) {
                System.out.println("En büyük sayi :" + sayi1);
            } else if (sayi2 > sayi1 && sayi2 > sayi3) {
                System.out.println("En büyük sayi :" + sayi2);
            } else {
                System.out.println("En büyük sayi :" + sayi3);
            }
        } else {
            System.out.println("Eşit sayı girmeyiniz!!");
        }
    }
}
