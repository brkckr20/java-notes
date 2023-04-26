// parametreli metotlar

public class metod2 {

    public static void main(String[] args) {
        String mesaj = "Bugün hava nice.";
        String yeni = mesaj.substring(0, 2);
        System.out.println(yeni);
        int x = topla(4, 7);
        System.out.println(x);
        String sehir = sehirVer();
        System.out.println(sehir);
        int toplam = topla2(2, 3, 4, 5, 6, 54, 43, 5);
        System.out.println("Toplamlar : " + toplam);
    }

    public static void ekle() {
        System.out.println("Veritabanına ekleniyor..");
    }

    public static void sil() {
        System.out.println("Veritabanından siliniyor..");
    }

    public static void guncelle() {
        System.out.println("Veritabanında güncelleniyor..");
    }

    public static int topla(int sayi1, int sayi2) { // bu fonksiyon int türünde değer döndürür
        return sayi1 + sayi2;
    }

    public static int topla2(int... sayilar) { // istediğim kadar int değer gönderebilirim demek - variables arguments
        int toplam = 0;
        for (int sayi : sayilar) {
            toplam += sayi;
        }
        return toplam;
    }

    public static String sehirVer() {
        return "Denizli";
    }
}
