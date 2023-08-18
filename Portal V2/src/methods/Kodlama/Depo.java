package methods.Kodlama;

import helpers.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.MDepoKodlama;
import utils.Bildirim;

public class Depo {

    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    PreparedStatement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    DefaultTableModel tabloDepoListesi;

    public void depoKaydet(int id, JTextField txt) {
        if (id == 0) {
            try {
                connection = dbHelper.getConnection();
                String sql = "INSERT INTO depo_kodlama (ad) values (?)";
                statement = connection.prepareStatement(sql);
                statement.setString(1, txt.getText());
                statement.executeUpdate();
                Bildirim.basarili("Kayıt işlemi başarılı!");
            } catch (Exception e) {

            }
        } else {
            System.out.println("güncelle");
        }
    }

}
