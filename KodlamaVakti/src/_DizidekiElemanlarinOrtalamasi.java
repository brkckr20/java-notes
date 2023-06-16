
import java.util.Scanner;

public class _DizidekiElemanlarinOrtalamasi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] notlar = new int[7];
        int toplam = 0;
        System.out.println("Hoşgeldiniz. Notlarınızı sırayla giriniz : ");
        System.out.print("Mat 1 : ");
        notlar[0] = scanner.nextInt();
        System.out.print("Türkçe : ");
        notlar[1] = scanner.nextInt();
        System.out.print("Fizik : ");
        notlar[2] = scanner.nextInt();
        System.out.print("Tarih : ");
        notlar[3] = scanner.nextInt();
        System.out.print("Kimya : ");
        notlar[4] = scanner.nextInt();
        System.out.print("Beden : ");
        notlar[5] = scanner.nextInt();
        System.out.print("Müzik : ");
        notlar[6] = scanner.nextInt();

        for (int not : notlar) {
            toplam += not;
        }
        System.out.println("Ortalama : " + (toplam / notlar.length));
    }
}
