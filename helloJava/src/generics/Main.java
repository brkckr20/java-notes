package generics;

public class Main {

    public static void main(String[] args) {
        MyList<Customer> sehirler = new MyList<Customer>(); // java da ikinci MyList<> kısım boş geçilse de olur
        sehirler.add(new Customer());
    }
}
