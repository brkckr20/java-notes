package abstractclass.demo;

public class CustomerManager {

    BaseDatabaseManager databaseManager;

    public void getCustomers() {
        databaseManager.getData();
    }
}
