package abstractclass.demo;

public class OracleDatabaseManager extends BaseDatabaseManager {

    @Override
    public void getData() {
        System.out.println("Oracle database veri getirildi...");
    }

}
