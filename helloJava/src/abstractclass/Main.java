package abstractclass;

public class Main {

    public static void main(String[] args) {
        WomanGameCalculator womanGameCalculator = new WomanGameCalculator();
        ManGameCalculator manGameCalculator = new ManGameCalculator();
        KidsGameCalculator kidsGameCalculator = new KidsGameCalculator();

        womanGameCalculator.hesapla();
        manGameCalculator.hesapla();
        kidsGameCalculator.hesapla();

        womanGameCalculator.gameOver();
 
    }
}
