
public class RecursiveMetotlar {

    public static void main(String[] args) {
        System.out.println(r(10));
    }

    static int add(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    static int r(int x) {
        if (x == 1) {
            return 1;
        }
        return x + r(x - 1);
    }

}
