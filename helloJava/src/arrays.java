
public class arrays {

    public static void main(String[] args) {
        //dizi tanimlama
        String[] ogrenciler = new String[3]; // sağ kısım kaç elemandan oluşacak
        ogrenciler[0] = "Burak";
        ogrenciler[1] = "Aynur";
        ogrenciler[2] = "Furkan";
        //ögrencilerin for dongusuyle ekrana yazdırılması islevi
        for (int i = 0; i < ogrenciler.length; i++) {
            System.out.println("Öğrenci : " + ogrenciler[i]);
        }

        System.out.println("--------------------");

        /* diğer yol ile for kullanılması işlevi  */
        for (String ogrenci : ogrenciler) {
            System.out.println("Öğrenci x : " + ogrenci);
        }
        System.out.println("--------------------");

        //ReCap Demo - with Array
        // double[] myList = new double[4];
        double[] myList = {1.2, 3.4, 8.6, 7.1};
        double total = 0;
        double max = myList[0];
        for (double number : myList) {
            if (max < number) {
                max = number;
            }
            total = total + number;
        }
        System.out.println("Sayilarin Toplamı : " + total);
        System.out.println("En Büyük Sayı : " + max);

        System.out.println("--------------------");

        //ÇOK BOYUTLU DIZILER
        String[][] sehirler = new String[3][3];
        sehirler[0][0] = "İstanbul";
        sehirler[0][1] = "Bursa";
        sehirler[0][2] = "Bilecik";
        sehirler[1][0] = "Ankara";
        sehirler[1][1] = "Konya";
        sehirler[1][2] = "Nevşehir";
        sehirler[2][0] = "Denizli";
        sehirler[2][1] = "Muğla";
        sehirler[2][2] = "Manisa";

        for (int i = 0; i <= 2; i++) {
            System.out.println("----");
            for (int j = 0; j <= 2; j++) {
                System.out.println(sehirler[i][j]);
            }
        }

        /* çıktı
         ----
         İstanbul
         Bursa
         Bilecik
         ----
         Ankara
         Konya
         Nevşehir
         ----
         Denizli
         Muğla
         Manisa
        
         */
    }
}
