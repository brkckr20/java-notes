package abstractclass.demo;

public class SqlServerDatabaseManager extends BaseDatabaseManager {

    @Override
    public void getData() {
        System.out.println("Sql Server database veri getirildi...");
    }

}
