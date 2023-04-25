package miniProjects;

public class mukemmelSayilar {

    // mükemmel sayı : kendisinden hariç bölünebilen sayıların toplamı kendisi yapan sayılar 6 - 28 gibi
    public static void main(String[] args) {
        int number = 27;
        int toplam = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                toplam += i;
            }
        }
        if (number == toplam) {
            System.out.println(number + " sayisi mükemmel sayidir.");
        } else {
            System.out.println(number + " sayisi mükemmel sayi degildir");
        }
    }
}
