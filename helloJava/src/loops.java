
public class loops {

    public static void main(String[] args) {
        //for döngüsü
        for (int i = 1; i < 10; i += 2) {
            System.out.println("Gelen sayi : " + i);
        }
        System.out.println("Döngü bitti...");

        // while döndüsü
        int i = 1;
        while (i < 10) {
            System.out.println("gelen sayi :" + i);
            i += 2; //sayac artırılmaması durumunda sonsuz döngüye girer
        }
        System.out.println("While döngüsü bitti");

        // do while döngüsü ( -şart sağlanmazsa bile bir kere çalışır)
        int y = 1;
        System.out.println("do while döngüsü başlıyor...");
        do {
            System.out.println("Gelen y sayisi :" + y);
            y++;
        } while (y < 10);
        System.out.println("do while döngüsü bitti...");
    }
}
