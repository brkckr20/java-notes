
import java.util.Scanner;

public class NotOrtalamasiHesapla {

    public static void main(String[] args) {
        int quiz, vize, finall;
        float ortalama;

        Scanner input = new Scanner(System.in);
        System.out.print("Quiz giriniz : ");
        quiz = input.nextInt();
        System.out.print("Vize giriniz : ");
        vize = input.nextInt();
        System.out.print("Final giriniz : ");
        finall = input.nextInt();
        ortalama = (quiz + vize + finall) / 3;

        System.out.println("Ortalama :" + ortalama);

        if (ortalama < 50) {
            System.out.println("Kaldınız");
        } else {
            System.out.println("Geçtiniz");
        }
    }
}
