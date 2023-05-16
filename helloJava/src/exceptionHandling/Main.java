package exceptionHandling;

public class Main {

    public static void main(String[] args) {

        try {
            int[] sayilar = new int[]{1, 2, 3, 4, 5, 65};
            System.out.println("sayilar " + sayilar[6]);

        } catch (Exception e) { // hata mesajını parametre olarak alır
            System.out.println("Hata meydana geldi -> : " + e);
        } finally {
            System.out.println("En son calisacak blok"); // hata alsa da kod çalıssa da bu blok calisir
        }
    }
}
