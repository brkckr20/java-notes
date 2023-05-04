package polymorphism;

public class CustomerManager {
    
    private BaseLogger baseLogger;
    
    public CustomerManager(BaseLogger logger) {
        this.baseLogger = logger;
    }
    
    public void Add() {
        System.out.println("Müşteri veritabanına eklendi...");
        this.baseLogger.Log("Log mesajı customerManager");
    }
}
