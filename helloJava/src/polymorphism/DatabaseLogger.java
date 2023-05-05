package polymorphism;

public class DatabaseLogger extends BaseLogger {

    //overriding - baselogger dosyasındaki Log methodunu override ediyoruz
    public void log(String message) {
        System.out.println("Logged to database : " + message);
    }

}
