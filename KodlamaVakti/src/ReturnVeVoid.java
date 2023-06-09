
public class ReturnVeVoid {

    public static void main(String[] args) {
        topla(3,4);
        int sonuc = toplam(2, 23);
        System.out.println("Sonuc : " + sonuc);
    }

    static void topla(int x, int y) {
        System.out.println("Toplam : " + (x + y));
    }
    
    static int toplam(int x, int y){ // işlem sonucunda geriye int türünde bir veri döndürecek
        return x + y;
    }

}
