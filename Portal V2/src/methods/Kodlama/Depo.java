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
    DefaultTableModel modelTabloDepoListesi;

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
                e.printStackTrace();
            }
        } else {
            System.out.println("güncelle");
        }
    }

    public ArrayList<MDepoKodlama> depoKodlariListele() throws SQLException {
        ArrayList<MDepoKodlama> depoKodListesi = null;
        try {
            connection = dbHelper.getConnection();
            statement = (PreparedStatement) connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM depo_kodlama");
            depoKodListesi = new ArrayList<MDepoKodlama>();
            while (resultSet.next()) {
                depoKodListesi.add(new MDepoKodlama(
                        resultSet.getInt("id"),
                        resultSet.getString("ad")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return depoKodListesi;
    }

    public void depoKodlariniTabloyaYansit(JTable tabloAdi) {
        modelTabloDepoListesi = (DefaultTableModel) tabloAdi.getModel();
        modelTabloDepoListesi.setRowCount(0);
        try {
            ArrayList<MDepoKodlama> depoKodListesi = depoKodlariListele();
            for (MDepoKodlama liste : depoKodListesi) {
                Object[] row = {
                    liste.getId(),
                    liste.getDepoAdi()
                };
                modelTabloDepoListesi.addRow(row);
            }
        } catch (Exception e) {
            System.out.println("ex : " + e.getMessage());
            e.printStackTrace();
        }
    }

}
