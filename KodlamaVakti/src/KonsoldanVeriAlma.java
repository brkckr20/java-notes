
import java.util.Scanner;


public class KonsoldanVeriAlma {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //kullanıcı dan veri alma sınıfı
        System.out.print("Adınızı giriniz: ");
        String name = input.nextLine();
        System.out.println("Name : " +name);
        int a,b;
        System.out.print("A sayısı: ");
        a = input.nextInt();
        System.out.print("B sayısı: ");
        b = input.nextInt();
        System.out.println("A + B :" + (a+b));
    }
}
