
public class RecursiveMetotlar {

    public static void main(String[] args) {
        //System.out.println(r(10));

        System.out.println("Fibonacci : " + proje(7));
    }

    static int add(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }
// recursive hali

    static int r(int x) {
        if (x == 1) {
            return 1;
        }
        return x + r(x - 1);
    }

    static int proje(int n) { // fibonacci örneği
        // f(6) = f(4) + f(5);
        if (n == 1 || n == 2) {
            return 1;
        }
        return proje(n - 1) + proje(n - 2);
    }

}
