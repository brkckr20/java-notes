
public class ForEachKullanimi {

    public static void main(String[] args) {
        int[] liste = new int[4];
        //int[] liste = {1,2,3};
        liste[0] = 1;
        liste[1] = 2;
        liste[2] = 3;
        liste[3] = 4;
        //
        for (int val : liste) {
            System.out.println("Sayi " + val);
        }
        System.out.println("--------------------------");
        
        // çok boyutlu diziler : foreach kullanımı

        int[][] tablo2 = new int[2][3];
        tablo2[0][0] = 1;
        tablo2[0][1] = 75;
        tablo2[0][2] = 10;
        tablo2[1][0] = 2;
        tablo2[1][1] = 21;
        tablo2[1][2] = 32;

        for (int[] sutun : tablo2) {
            for (int valuem : sutun) {
                System.out.print(valuem + " ");
            }
            System.out.println();
        }
    }
}
