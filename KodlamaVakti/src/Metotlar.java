
public class Metotlar {

    public static void main(String[] args) {
        welcomeToApp(3);
        System.out.println("2. metot");
        welcomeToApp(34);
        power(2, 4);
    }

    static void welcomeToApp(int x) {
        int sonuc = (x + 2) * 6;
        System.out.println("Sonuc : " + sonuc);
    }

    static void power(int num1, int num2) {
        int sonuc = 1;
        for (int i = 1; i <= num2; i++) {
            sonuc *= num1;
        }
        System.out.println("Üs sonucu :" + sonuc);
    }
}
