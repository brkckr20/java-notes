package threadingDemo1;

public class KronomentreThread implements Runnable {

    private Thread thread;
    private String threadName;

    public KronomentreThread(String threadName) {
        this.threadName = threadName;
        System.out.println("Oluşturuluyor : " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Çalıştırılıyor : " + threadName);

        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(threadName + " : " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Hata : " + threadName);
        }

        System.out.println("Thread sonlandı..." + threadName);
    }

    public void start() {
        System.out.println("Thread nesnesi oluşuyor...");
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
