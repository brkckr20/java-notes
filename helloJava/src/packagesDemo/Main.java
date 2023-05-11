package packagesDemo;

import java.util.Scanner; //baska bir paketin dahil edilmesi islemi
import packagesDemo.matematik.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adınızı Giriniz : ");
        String isim = scanner.nextLine();
        System.out.println("Merhaba " + isim);

        DortIslem dortIslem = new DortIslem();
        dortIslem.topla(1, 45);

        Logaritma logaritma = new Logaritma();
        System.out.println("---- " + logaritma.logaritmaHesapla());

    }
}
