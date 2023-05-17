package exceptionHandling;

public class Main {

    public static void main(String[] args) {

        try {
            int[] sayilar = new int[]{1, 2, 3, 4, 5, 65};
            System.out.println("sayilar " + sayilar[6]);

        } catch (StringIndexOutOfBoundsException e) { // hata mesajını parametre olarak alır
            System.out.println("Hata meydana geldi -> : " + e);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("hata satırı 2");
        } catch (Exception ex) {
            System.out.println("her türlü bu Exception blogu calisir. Hepsinin kapsayıcısı");
        } finally {
            System.out.println("En son calisacak blok"); // hata alsa da kod çalıssa da bu blok calisir
        }
    }
}
