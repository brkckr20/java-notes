package arrayListDemo.arrayListWithClass;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(12, "Burak", "İpsum"));
        customers.add(new Customer(122, "Ahmet", "İpsum1"));
        customers.add(new Customer(121, "Veysel", "İpsum2"));

        for (Customer customer : customers) {
            System.out.println(customer.firstName);
        }
    }
}
