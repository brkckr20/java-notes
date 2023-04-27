package classes;

public class classes {

    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        customerManager.Add();
        customerManager.Remove();
        customerManager.Update();

        System.out.println("----");
        Example dortIslem = new Example();
        int sonuc = dortIslem.Topla(4, 32);
        System.out.println("Sonuç " + sonuc);
    }
}
