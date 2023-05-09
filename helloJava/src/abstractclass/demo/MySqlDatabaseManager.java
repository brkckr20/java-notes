/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass.demo;

/**
 *
 * @author BILGIISLEM
 */
public class MySqlDatabaseManager extends BaseDatabaseManager {

    @Override
    public void getData() {
        System.out.println("Mysql veri getirildi...");
    }

}
