
public class conditionals {

    public static void main(String[] args) {
        int sayi = 14;
        if (sayi == 12) {
            System.out.println("sayi 12");
        } else if (sayi == 13) {
            System.out.println("sayi 13");
        } else {
            System.out.println("sayi ne 12 ne de 13 dür");
        }

        //ReCapDemo Application
        int sayi1 = 203, sayi2 = 112, sayi3 = 43;
        int enbuyuk = sayi1;

        if (sayi1 < sayi2 && sayi3 < sayi2) {
            System.out.println("En büyük sayi, sayi2");
        } else if (sayi1 > sayi2 && sayi1 > sayi3) {
            System.out.println("En büyük sayi, sayi1");
        } else {
            System.out.println("En büyük sayi, sayi3");
        }

        System.out.println("------------");
        //diğer yol
        if (enbuyuk < sayi2) {
            enbuyuk = sayi2;
        }
        if (enbuyuk < sayi3) {
            enbuyuk = sayi3;
        }

        System.out.println("en büyük sayi :" + enbuyuk);

        //switch blokları
        System.out.println("------------");

        char not = 'B';
        switch (not) {
            case 'A':
                System.out.println("Perfect : Geçtiniz");
                break;
            case 'B':
            case 'D':
                System.out.println("Ehh işte idare eder");
                break;
            default:
                System.out.println("Geçersiz not");
                break;
        }
    }
}
