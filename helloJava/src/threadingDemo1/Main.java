package threadingDemo1;

public class Main {

    public static void main(String[] args) {
        KronomentreThread kronomentre1 = new KronomentreThread("thread1");
        KronomentreThread kronomentre2 = new KronomentreThread("thread2");
        KronomentreThread kronomentre3 = new KronomentreThread("thread3");

        kronomentre1.start();
        kronomentre2.start();
        kronomentre3.start();
    }
}
