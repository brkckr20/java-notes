package miniProjects;

public class arkadasSayilar {

    public static void main(String[] args) {
        // arkadas sayilar - kendileri haric pozitif tam bolenlerin toplamı birbirine esit olan tüm sayıların toplamı
        int sayi1 = 220;
        int sayi2 = 284;
        int toplam1 = 0;
        int toplam2 = 0;
        for (int i = 1; i < sayi1; i++) {
            if (sayi1 % i == 0) {
                toplam1 = toplam1 + i;
            }
        }
        for (int i = 1; i < sayi2; i++) {
            if (sayi2 % i == 0) {
                toplam2 = toplam2 + i;
            }
        }
        if (sayi1 == toplam2 && sayi2 == toplam1) { // && -> ve operatoru    || veya operatörü
            System.out.println("Sayilar arkadaş sayıdır.");
        } else {
            System.out.println("Sayilar arkadaş değildir.");
        }
    }
}
