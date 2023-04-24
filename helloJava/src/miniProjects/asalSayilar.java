package miniProjects;

public class asalSayilar {

    public static void main(String[] args) {
        int sayi = 11;
        int kalan = sayi % 2; //ikiye bölümden kalan
        boolean asalMi = true;

        if (sayi > 1) {
            for (int i = 2; i < sayi; i++) {
                if (sayi % i == 0) {
                    asalMi = false;
                }
            }
            if (asalMi) {
                System.out.println("Sayi Asal");
            } else {
                System.out.println("Sayi Asal Değil");
            }
        } else {
            System.out.println("Girilen sayi 2 veya daha büyük olmalıdır...");
        }

    }
}
