
import java.util.Scanner;

public class HesapMakinasi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sonuc = 0;
        System.out.print("İlk sayı : ");
        int sayi1 = input.nextInt();
        System.out.print("\nİkinci sayı : ");
        int sayi2 = input.nextInt();
        System.out.print("\nLütfen Yapmak istediğiniz işlemi seçin : ");
        System.out.print("\n1 toplama, 2 çıkarma, 3 çarpma, 4 bölme : ");
        int islem = input.nextInt();
        System.out.print("\nSeçiminiz  : " + islem);
        if (islem == 1) {
            sonuc = sayi1 + sayi2;
        }
        if (islem == 2) {
            sonuc = sayi1 - sayi2;
        }
        if (islem == 3) {
            sonuc = sayi1 * sayi2;
        }
        if (islem == 4) {
            sonuc = sayi1 / sayi2;
        }
        System.out.println("\nSonuç : " + sonuc);
    }

}
