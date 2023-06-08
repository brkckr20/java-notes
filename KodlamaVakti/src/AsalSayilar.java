
import java.util.Scanner;


public class AsalSayilar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sayi;
        boolean asal = true;
        do{
            System.out.println("Sayi giriniz : ");
           sayi=  scanner.nextInt();
        }while(sayi < 2);
        for (int i = 2; i < sayi; i++) {
            if (sayi %i ==0) {
                asal = false;
                break;
            }
        }
        if (asal) {
            System.out.println("Girilen sayi asaldir");
        }else{
            System.out.println("Girilen sayi asal degildir");
        }
    }
}
