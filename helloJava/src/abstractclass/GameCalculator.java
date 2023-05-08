package abstractclass;

public abstract class GameCalculator {

    public abstract void hesapla();// cağırılan yerde override edilmek zorunda

    /*public void hesapla() {
     System.out.println("Puanınız : 100");
     }*/
    public void gameOver() {
        System.out.println("Oyun bitti...");
    }
}

// abstract classlar new lenemez